package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p11726 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp = new int[10001];
        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= 1000; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            dp[i] %= 10007;
        }
        System.out.println(dp[n]);

    }
}
