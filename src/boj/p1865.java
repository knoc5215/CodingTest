package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1865 {
    static ArrayList<Node>[] arrayLists;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {

            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());  //지점
            int m = Integer.parseInt(stringTokenizer.nextToken());  //도로
            int w = Integer.parseInt(stringTokenizer.nextToken());  //웜홀

            arrayLists = new ArrayList[n + 1];
            dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arrayLists[i] = new ArrayList<>();
                dist[i] = 987654321;
            }


            for (int i = 0; i < m; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(stringTokenizer.nextToken());
                int e = Integer.parseInt(stringTokenizer.nextToken());
                int t = Integer.parseInt(stringTokenizer.nextToken());

                // 도로는 양방향
                arrayLists[s].add(new Node(e, t));
                arrayLists[e].add(new Node(s, t));
            }

            for (int i = 0; i < w; i++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(stringTokenizer.nextToken());
                int e = Integer.parseInt(stringTokenizer.nextToken());
                int t = Integer.parseInt(stringTokenizer.nextToken());

                // 웜홀은 단방향에 음수 코스트를 갖는다
                arrayLists[s].add(new Node(e, -t));
            }

            boolean isPossible = true;
            dist[1] = 0;
            int count = 0;

            while (isPossible && count < n) {
                isPossible = false;
                count++;

                for (int v = 1; v <= n; v++) {
                    for (Node nextNode : arrayLists[v]) {
                        if (dist[nextNode.to] > dist[v] + nextNode.cost) {  // 목적지의 거리 > 현재 정점까지의 거리 + 현재 정점에서 목적지까지의 거리
                            dist[nextNode.to] = dist[v] + nextNode.cost;
                            isPossible = true; // 갱신여부(음수 사이클이 있으면 계속 true로 돌아간다)
                        }
                    }
                }
            }

            if (count == n) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }

    }

    static class Node {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
