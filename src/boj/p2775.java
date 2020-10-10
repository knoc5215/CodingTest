package boj;

import java.util.Scanner;

public class p2775 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            arr = new int[k + 1][n + 1];  // 0층 ~ k층, 1호 ~ n호 부터 시작한다
            for (int i = 1; i <= n; i++) {
                arr[0][i] = i;
            }

            for (int i = 1; i <= k; i++) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    sum += arr[i - 1][j];
                    arr[i][j] = sum;
                }
            }

            System.out.println(arr[k][n]);
        }
    }
}
