package boj;

import java.util.Scanner;

public class p1003 {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();

            dp = new int[41][2];
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j < 2; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
                }
            }

            System.out.println(dp[n][0] + " " + dp[n][1]);


        }
    }


}
