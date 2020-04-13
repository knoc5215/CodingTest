package swea;

import java.util.Scanner;

/*
    N개의 정점과 M개의 간선으로 구성된 가중치가 없는 무방향 그래프에서의 최장 경로의 길이를 계산하자.

 */
public class p2814 {
    static int N, M; // N 정점의 개수, M 간선의 개수
    static int[][] arr;
    static int ret;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();   // 정점
            M = sc.nextInt();   // 간선

            ret = 1;
            arr = new int[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[x][y] = 1;
                arr[y][x] = 1;
            }


            run();

            System.out.println("#" + test_case + " " + ret);
        }
    }

    static void run() {
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            int startIdx = i;
            int startCnt = 0;
            DFS(startIdx, startCnt);
        }
    }


    static void DFS(int target, int depth) {
        ret = Math.max(ret, depth);

        for (int col = 1; col <= N; col++) {
            if (arr[target][col] == 1 && !visit[col]) {
                visit[col] = true;
                DFS(col, depth + 1);
                visit[col] = false;

            }
        }

    }


}
