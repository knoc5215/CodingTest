package boj;

import java.util.Scanner;

public class p11727 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 2 * dp[i - 2];
            dp[i] %= 10007;
        }

        System.out.println(dp[n]);
    }
}
