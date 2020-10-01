package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11053 {
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
            dp[cur] = 1;    // 현재 위치의 dp = 1 로 초기화
            for (int before = 0; before < cur; before++) {  // 현재 위치 이전을 탐색하면서
                if (arr[before] < arr[cur] && dp[cur] <= dp[before]) {  // 현재위치가 더 크면서 && 부분 수열의 len(dp[before])가 현재보다 크거나 같다면
                    dp[cur] = dp[before] + 1; // 증가하는 길이 +1
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
