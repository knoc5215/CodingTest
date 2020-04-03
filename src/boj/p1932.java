package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1932 {
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[501][501];
        dp = new int[501][501];

        for (int i = 1; i <= N; i++) {
            String inputs = br.readLine();
            StringTokenizer st = new StringTokenizer(inputs);
            int j = 1;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(st.nextToken());
            }
        }


        dp[1][1] = arr[1][1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = arr[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
                System.out.println("dp[" + i + "][" + j + "] = " + dp[i][j]);
            }
        }

        int max = -1;
        for (int j = 1; j <= N; j++) {
            max = Math.max(dp[N][j], max);
        }

        System.out.println(max);

    }
}
