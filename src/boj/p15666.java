package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p15666 {
    static int N, M;
    static int[] arr;
    static int[] ret;
    static Set<String> set = new HashSet<>();
    static boolean[] visit;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

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

        bufferedWriter.flush();
        bufferedWriter.close();


    }

    private static void DFS(int start, int depth) throws IOException {
        if (depth == M) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int val : ret) {
                stringBuilder.append(val).append(" ");
            }
            String str = stringBuilder.toString();

            if (!set.contains(str)) {
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
            set.add(str);

            return;
        }

        for (int i = start; i < N; i++) {
            ret[depth] = arr[i];
            DFS(i, depth + 1);
        }
    }
}
