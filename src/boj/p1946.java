package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p1946 {
    static int n;
    static ArrayList<Node> list;
    static int[] papers, interviews;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            papers = new int[n];
            interviews = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int in = Integer.parseInt(st.nextToken());
                papers[i] = p;
                interviews[i] = in;
                list.add(new Node(p, in));
            }

            Collections.sort(list, (o1, o2) -> o1.paper - o2.paper);    // 서류심사 높은 순위로 정렬

            int ans = n;
            int interRank = list.get(0).interview;  // 서류 1등의 면접점수
            for (int i = 1; i < list.size(); i++) { // 서류 2등 지원자부터 돌면서
                int nextInterRank = list.get(i).interview;
                if (interRank < nextInterRank) {    // 당연히 서류는 2등인데, 서류 1등의 면접등수보다 낮으면 탈락이지
                    ans--;
                } else {
                    interRank = nextInterRank;
                }

            }

            System.out.println(ans);


        }


    }

    static class Node {
        int paper, interview;

        public Node(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }
}
