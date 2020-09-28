package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2294 {
    public static final int INF = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = INF;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= k; j++) {
                /*
                dp[j] = j원을 만드는 최소 동전의 개수
                      max(현재 j원을 만들어 놓은 동전의 개수 그대로 쓰거나,
                           j-coin을 만들어 놓은 동전의 개수에다가 + 현재 coin을 더하거나(+1 개수)
                          )
                 */
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        if (dp[k] == INF) dp[k] = -1;
        System.out.println(dp[k]);


    }
}
