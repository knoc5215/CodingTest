package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p1699 {
    static int n;
    static int[] dp = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Arrays.fill(dp, 0);
        dp[0] = 0;
        dp[1] = 1;      // dp[n] = n의 제곱수의 합을 표현하는 최소항의 개수
        for (int i = 2; i <= n; i++) {
            dp[i] = i;  // 우선 자기 자신으로 초기화 (1*1들의 합으로 표현할 수 있으니까)
            for (int j = 1; j * j <= i; j++) {  // j는 제곱수를 나타낸다
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);   // dp[i-j*j] ? i-j*j의 제곱수 합의 최소개수
            }
        }


        for (int i = 1; i <= 100000; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] || dp[i] == 0) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }

        System.out.println(dp[n]);


    }
}
