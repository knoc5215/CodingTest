package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11660 {
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][n + 1];


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int ans = solve(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), dp);
            System.out.println(ans);
        }


    }

    static int solve(int fromX, int fromY, int toX, int toY, int[][] dp) {
        return dp[toX][toY] - dp[fromX - 1][toY] - dp[toX][fromY - 1] + dp[fromX - 1][fromY - 1];
    }


    static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
