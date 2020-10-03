package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p1309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] dp = new int[n + 1][3]; // dp[n][j] = n번째열의 경우의 수 j=0 배치안함, j=1 위쪽, j=2 아래쪽
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][0] + dp[i - 1][2];
                } else {
                    dp[i][j] = dp[i - 1][0] + dp[i - 1][1];
                }
                dp[i][j] %= 9901;
            }
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}
