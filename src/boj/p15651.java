package boj;

import java.util.Scanner;

public class p15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        DFS(0);

        System.out.println(stringBuilder);


    }

    private static void DFS(int depth) {
        if (depth == M) {
            for (int val : arr) {
                stringBuilder.append(val).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            DFS(depth + 1);
        }
    }

}
