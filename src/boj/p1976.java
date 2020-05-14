package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/* 여행 가자 */
public class p1976 {
    static int N, M;
    static int[][] map;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        p = new int[N + 1];
        Arrays.fill(p, -1);

        for (int i = 1; i <= N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }

        String[] plan = br.readLine().split(" ");

        connect();

        Set<Integer> set = new HashSet<>();
        for (String city : plan) {
            int next = Integer.parseInt(city);
            set.add(find(next));
        }

        System.out.println((set.size() == 1) ? "YES" : "NO");

    }

    public static void connect() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) {
                    union(i, j);
                }
            }
        }
    }

    public static int find(int a) {
        if (p[a] < 0) {
            return a;
        }
        p[a] = find(p[a]);
        return p[a];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        p[b] = a;
    }


}
