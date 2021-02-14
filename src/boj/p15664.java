package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p15664 {
    static int N, M;
    static int[] arr;
    static int[] ret;
    static Set<String> set = new HashSet<>();
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        arr = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(arr);

        ret = new int[M];
        visit = new boolean[N];

        DFS(0, 0);


    }

    private static void DFS(int start, int depth) {
        if (depth == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int val : ret) {
                stringBuilder.append(val).append(" ");
            }
            String str = stringBuilder.toString();

            if (!set.contains(str)) {
                System.out.println(str);
            }
            set.add(str);

            return;
        }

        for (int i = start; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ret[depth] = arr[i];
                DFS(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }
}
