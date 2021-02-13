package boj;

import java.util.Scanner;

public class p15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        DFS(1, 0);

        System.out.println(stringBuilder);


    }

    private static void DFS(int start, int depth) {
        if (depth == M) {
            for (int val : arr) {
                stringBuilder.append(val).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            DFS(i, depth + 1);
        }
    }

}
