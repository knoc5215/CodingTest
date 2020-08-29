package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p5567 {
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
            map[y][x] = 1;

        }

        System.out.println(run());


    }

    static int run() {
        int ans = 0;
        boolean[] visit = new boolean[n + 1];

        for (int i = 2; i < n + 1; i++) {
            if (map[1][i] == 1) {
                if (!visit[i]) {
                    visit[i] = true;
                    ans++;
                }
                for (int j = 2; j < n + 1; j++) {
                    if (map[i][j] == 1 && !visit[j]) {
                        visit[j] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }


}
