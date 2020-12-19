package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1018 {
    static int N, M;
    static int[][] arr;
    public static final int CUT_LEN = 8;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = (row.charAt(j) == ('W')) ? 1 : 0;
            }
        }

        for (int i = 0; i < N - 8 + 1; i++) {
            for (int j = 0; j < M - 8 + 1; j++) {
                int rePaintCnt = checkBoard(i, j);
                rePaintCnt = Math.min(rePaintCnt, 64 - rePaintCnt);
                min = Math.min(min, rePaintCnt);
            }
        }

        System.out.println(min);
    }

    public static int checkBoard(int x, int y) {
        int cnt = 0;

        int flag = arr[x][y];

        for (int i = x; i < x + CUT_LEN; i++) {
            for (int j = y; j < y + CUT_LEN; j++) {
                int cur = arr[i][j];
                if (cur != flag) {
                    cnt++;
                }
                flag = (flag == 1) ? 0 : 1;
            }
            flag = (flag == 1) ? 0 : 1;
        }
        return cnt;
    }


}
