package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630 {
    static int N;
    static int[][] arr;
    static int white = 0, blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkColor(N, 0, 0);
        System.out.println(white);
        System.out.println(blue);


    }

    private static void checkColor(int n, int x, int y) {
        if (isSameColor(n, x, y)) {
            if (arr[x][y] == 0) white++;
            else blue++;
            return;
        }

        checkColor(n / 2, x, y);
        checkColor(n / 2, x + n / 2, y);
        checkColor(n / 2, x, y + n / 2);
        checkColor(n / 2, x + n / 2, y + n / 2);
    }

    private static boolean isSameColor(int n, int x, int y) {
        int color = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


}
