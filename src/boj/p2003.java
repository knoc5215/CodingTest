package boj;

import java.util.Scanner;

/*
    two pointer
    N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다.
    이 수열의 i번째 수부터 j번째 수까지의 합 A[i]+A[i+1]+…+A[j-1]+A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
public class p2003 {
    static int N, M;
    static int[] arr;
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[10000];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int s, e;
        s = e = 0;

        int sum = 0;
        while (true) {
            if (sum > M) {
                sum -= arr[s++];
            } else if (e == N) {
                break;
            } else {
                sum += arr[e++];
            }

            if (sum == M) {
                ret++;
            }
        }

        System.out.println(ret);


    }
}
