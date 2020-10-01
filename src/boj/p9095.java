package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p9095 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            n = sc.nextInt();
            dp = new int[11];
            Arrays.fill(dp, 0);
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
            }

            System.out.println(dp[n]);


        }
    }
}
