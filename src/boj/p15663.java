package boj;

import java.util.*;

public class p15663 {
    static int N, M;
    static int[] arr, out;
    static boolean[] visit;
    static Set<String> set = new HashSet<>();

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


    }

    private static void DFS(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(out[i]).append(" ");
            }
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                System.out.println(sb.toString());
            }

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


