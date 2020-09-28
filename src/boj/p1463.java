package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p1463 {
    static int n;
    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Arrays.fill(dp, -1);

        int ret = run(n);
        System.out.println(ret);


    }

    static int run(int x) {
        if (x == 1) {   // 1일때 예외 케이스
            return 0;
        }
        if (dp[x] != -1) {  // 이미 구해짐
            return dp[x];
        }

        int ret = run(x - 1) + 1;   // 조건3
        if (x % 3 == 0) {   // 조건1
            ret = Math.min(ret, run(x / 3) + 1);    // 조건 1,3 최소값
        }

        if (x % 2 == 0) {
            ret = Math.min(ret, run(x / 2) + 1);    // 조건 1,3 최소값 vs 조건2
        }

        dp[x] = ret;
        return ret;


    }
}
