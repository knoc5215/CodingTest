package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9251 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] A = bufferedReader.readLine().toCharArray();
        char[] B = bufferedReader.readLine().toCharArray();

        dp = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(LCS(A.length - 1, B.length - 1, A, B));
    }

    static int LCS(int x, int y, char[] charsA, char[] charsB) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (dp[x][y] == -1) {
            dp[x][y] = 0;

            if (charsA[x] == charsB[y]) {
                dp[x][y] = LCS(x - 1, y - 1, charsA, charsB) + 1;
            } else {
                dp[x][y] = Math.max(LCS(x - 1, y, charsA, charsB), LCS(x, y - 1, charsA, charsB));
            }
        }

        return dp[x][y];
    }
}
