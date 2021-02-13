package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p15654 {
    static int N, M;
    static int[] arr, out;
    static boolean[] visit;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        out = new int[M];
        DFS(0);

        System.out.println(stringBuilder);


    }

    private static void DFS(int depth) {
        if (depth == M) {
            for (int val : out) {
                stringBuilder.append(val).append(' ');
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                out[depth] = arr[i];
                DFS(depth + 1);
                visit[i] = false;
            }
        }
    }

}
