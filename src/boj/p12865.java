package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p12865 {
    static int n, k;
    static int[][] dp;
    static int[] w, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        w = new int[n + 1];
        v = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            w[i] = weight;
            v[i] = value;
        }

        dp = new int[n + 1][k + 1]; //dp[n][k] = n번째 물건까지 k무게만큼 넣었을 때의 최대가치

        for (int i = 1; i <= n; i++) {  // 물건을 돌면서
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j]; // 기본적으로 이전 아이템의 가치를 저장한다.
                if (j - w[i] >= 0) {    // 현재 선택한 물건의 무게를 담을 수 있다면
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                    //이전 물건에서 구한 가치 vs (남은 무게일때의 가치 + 추가로 넣을 물건의 가치 )
                }
            }
        }

        System.out.println(dp[n][k]);


    }

    static class Item {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
