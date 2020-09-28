package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9465 {
    static int n;
    static int[][] arr;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[2][n];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp = new int[n + 1][3];
            /*
            dp[n][status] : n번째 열까지 도달했을때 status마다의 합계

             */

            for (int i = 1; i <= n; i++) {
                // status 0 --> 아무것도 뽑지 않았다 --> 왼쪽 열의 위/아래 뽑은 경우와 비교
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
                // status 1 --> 위쪽 뽑았다 --> max(왼쪽 열에서 안뽑은 경우, 왼쪽 열에서 아래쪽 뽑은 경우) + 현재 열의 위쪽 스티커
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[0][i - 1];
                // status 2 --> 아래쪽 뽑았다 --> max(왼쪽 열에서, 안뽑은 경우, 왼쪽 열에서 위쪽 뽑은 경우) + 현재 열의 아래쪽 스티커
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + arr[1][i - 1];
            }

            int ret = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
            System.out.println(ret);


        }

    }

}
