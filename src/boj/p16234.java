package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class p16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        int moveCnt = 0;

        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        while (true) {
            visit = new boolean[N][N];
            if (!check()) {
                moveCnt++;
            } else {
                break;
            }
        }
    }

    public static boolean check() {
        List<Node> list;
        boolean isDone = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    list = new LinkedList<>();
                    list.add(new Node(i, j));

                    int sum = DFS(i, j, list, 0);
                    if (list.size() > 1) {
                        change(sum, list);
                        isDone = false;
                    }
                }
            }
        }
        return isDone;
    }

    public static void change(int sum, List<Node> list) {
        int avg = sum / list.size();
        for (Node node : list) {
            map[node.x][node.y] = avg;
        }
    }

    public static int DFS(int x, int y, List<Node> list, int sum) {
        visit[x][y] = true;
        sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isRange(nx, ny)) continue;
            if (!visit[nx][ny]) {
                int diff = Math.abs(map[nx][ny] - map[x][y]);
                if (0 <= diff && diff <= R) {
                    list.add(new Node(nx, ny));
                    sum += DFS(nx, ny, list, sum);
                }
            }
        }
        return sum;
    }


    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
