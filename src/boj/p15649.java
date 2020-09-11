package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p15649 {
    static int N, M;
    static int[] number;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            number[i] = i;
        }
        visit = new boolean[N + 1];

        backtracking(0, new ArrayList<>());


    }

    static void backtracking(int len, List<Integer> list) {
        if (len == M) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(number[i]);
                backtracking(len + 1, list);

                list.remove(list.size() - 1);
                visit[i] = false;
            }
        }
    }
}
