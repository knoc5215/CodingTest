package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1967 {
    static int n;
    static ArrayList<Node>[] arrayLists;
    static boolean[] visit;
    static int max_dist;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        arrayLists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            arrayLists[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());

            // 양방향으로 추가
            arrayLists[from].add(new Node(to, cost));
            arrayLists[to].add(new Node(from, cost));
        }

        max_dist = Integer.MIN_VALUE;
        index = 0;  // 가장 거리가 먼 리프노드 인덱스
        visit = new boolean[n + 1];
        DFS(1, 0);  // 정점인 루트 1번에서 시작해서 끝까지 내려가보자

        max_dist = Integer.MIN_VALUE;
        visit = new boolean[n + 1];
        DFS(index, 0);  // 가장 거리가 먼 리프노드 인덱스에서 시작해서, 제일 먼곳을 찾는다

        System.out.println(max_dist);

    }

    private static void DFS(int current, int sum) {
        visit[current] = true;  // 정점 방문 체크
        if (max_dist < sum) {   // 가장 멀다면, 최대거리값을 갱신해주고 인덱스도 갱신해준다
            max_dist = sum;
            index = current;
        }

        for (Node nextNode : arrayLists[current]) {
            if (!visit[nextNode.index]) {   // 아직 방문한 정점이 아닌 경우
                DFS(nextNode.index, nextNode.value + sum);
            }
        }
    }


    static class Node {
        int index, value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }


}
