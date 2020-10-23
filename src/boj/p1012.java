package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1012 {
    static int m, n, k;
    static int[][] matrix;
    static int area;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            matrix = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1;
            }
            visit = new boolean[n][m];
            area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1 && !visit[i][j]) {
                        visit[i][j] = true;
                        DFS(i, j);
                        area++;
                    }
                }
            }
            System.out.println(area);


        }
    }

    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx, ny) && matrix[nx][ny] == 1 && !visit[nx][ny]) {
                visit[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
