package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
가장 긴 감소하는 부분 수열
 */
public class p11722 {
    static int[] dp;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n];

        dp[0] = 1;
        for (int cur = 1; cur < n; cur++) {
            dp[cur] = 1;
            for (int before = 0; before < cur; before++) {
                if (arr[before] > arr[cur] && dp[cur] <= dp[before]) {
                    dp[cur] = dp[before] + 1;
                }
            }
        }

        int max = 0;
        for (int len : dp) {
            max = Math.max(max, len);
        }

        System.out.println(max);
    }

}
