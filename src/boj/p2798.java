package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2798 {
    public static int N, M;
    public static int[] arr;
    public static boolean[] visit;
    public static int answer = 0;
    public static int minDiff = Integer.MAX_VALUE;
    public static final int PEEK_COUNT = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            visit = new boolean[N];
            visit[i] = true;
            DFS(1, arr[i], i);
        }

        System.out.println(answer);
    }

    public static void DFS(int peek, int sumOfPeek, int from) {
        if (peek == PEEK_COUNT) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                if (visit[i]) {
                    total += arr[i];
                }
            }
            if (total <= M) {
                if (Math.abs(total - M) < minDiff) {
                    minDiff = Math.abs(total - M);
                    answer = total;
                }
            }
        } else {
            for (int i = from - 1; i >= 0; i--) {
                if (!visit[i]) {
                    visit[i] = true;
                    DFS(peek + 1, sumOfPeek + arr[i], i);
                    visit[i] = false;
                }
            }
        }
    }


}
