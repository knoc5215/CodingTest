package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
보물은 서로 간에 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.
 */
public class p2589 {
    static int N, M;
    static int[][] map, dist;
    static boolean[][] visit;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = input.charAt(j);
                if (ch == 'W') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 2;
                }
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    dist = new int[N][M];
                    visit = new boolean[N][M];
                    BFS(i, j);
                }
            }
        }

        System.out.println(max);


    }

    public static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (isRange(nx, ny) && map[nx][ny] == 2 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    queue.add(new Node(nx, ny));
                }
            }
        }
        max = Math.max(max, getMaxDist());
    }

    public static int getMaxDist() {
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dist[i][j]);
            }
        }

        return max;
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
