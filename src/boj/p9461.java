package boj;

import java.util.Scanner;

public class p9461 {
    static int n;
    static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for (int t = 0; t < testCase; t++) {
            int n = sc.nextInt();

            arr = new long[101];    // 미리 수열을 만들어 놓고, long 범위에 주의하자
            arr[1] = 1;
            arr[2] = 1;
            arr[3] = 1;
            arr[4] = 2;

            for (int i = 5; i <= 100; i++) {
                arr[i] = arr[i - 5] + arr[i - 1];   // 규칙성
            }

            System.out.println(arr[n]);


        }

    }


}
