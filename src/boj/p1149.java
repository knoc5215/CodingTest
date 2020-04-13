package boj;

import java.util.Scanner;

/*
    1번 집의 색은 2번 집의 색과 같지 않아야 한다.
    N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
    i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
 */
public class p1149 {
    static int N;
    static int[][] arr, dp;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[1000][3];
        dp = new int[1000][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N - 1][i]);
        }

        System.out.println(min);


    }


}
