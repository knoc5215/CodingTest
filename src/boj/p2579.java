package boj;


import java.util.Scanner;

/*
    계단 오르기
 */
public class p2579 {
    static int N;
    static int[] arr;
    static int[] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[300];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        d = new int[300];

        d[0] = arr[0];

        d[1] = Math.max(arr[1], arr[0] + arr[1]);       // 2 step vs 1 step * 2
        d[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

        for (int i = 3; i <= N; i++) {
            d[i] = Math.max(d[i - 3] + arr[i - 1] + arr[i], d[i - 2] + arr[i]);
        }

        System.out.println(d[N]);


    }
}
