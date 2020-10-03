package boj;

import java.util.Scanner;

/*
    가장 긴 바이토닉 부분 수열
    왼쪽에서 시작하는 LIS 최대길이
    오른쪽에서 시작하는 LIS 최대길이

 */
public class p11054 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 왼쪽부터 LIS
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }

            }
        }


        // 오른쪽부터 LIS
        int[] dp_reverse = new int[n];
        dp_reverse[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            dp_reverse[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[i] && dp_reverse[i] <= dp_reverse[j]) {
                    dp_reverse[i] = dp_reverse[j] + 1;
                }
            }
        }

        int max = -1;   // 가운데 값이 중복되므로 길이 -1 제거
        for (int i = 0; i < n; i++) {
            int sum = dp[i] + dp_reverse[i];
            max = Math.max(max, sum);
        }

        System.out.println(max - 1);


    }
}
