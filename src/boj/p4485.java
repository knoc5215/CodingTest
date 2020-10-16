package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p4485 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = 1;
        while (true) {
            String str = br.readLine();
            if (str.length() == 1 && Integer.parseInt(str) == 0) {
                return;
            }
            st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ans = dijkstra(n);
            System.out.println("Problem " + testCase++ + ": " + ans);

        }
    }

    static int dijkstra(int n) {
        int[][] dist = new int[n][n];
        boolean[][] visit = new boolean[n][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = map[0][0];
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Node(0, 0, 5));
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (visit[curNode.x][curNode.y]) {
                continue;
            }
            visit[curNode.x][curNode.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                if (isRange(nx, ny, n) && dist[nx][ny] > dist[curNode.x][curNode.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[curNode.x][curNode.y] + map[nx][ny];
                    queue.add(new Node(nx, ny, dist[nx][ny]));
                }
            }

        }

        return dist[n - 1][n - 1];
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static boolean isRange(int x, int y, int n) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
