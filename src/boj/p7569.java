package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7569 {
    static int M, N, H;
    static int[][][] map, dist;
    static int ikn, notIkn;

    //인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향
    static int[] dn = {0, 0, -1, 1};
    static int[] dm = {-1, 1, 0, 0};
    static int[] dh = {-1, 1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        dist = new int[H][N][M];
        for (int h = 0; h < H; h++) {

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    int status = Integer.parseInt(st.nextToken());
                    map[h][n][m] = status;
                    if (status == 1) {
                        queue.add(new Node(h, n, m));
                    }
                }
            }
        }
        System.out.println(run());

    }

    //만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
    static int run() {


        boolean[][][] visit = new boolean[H][N][M];
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                visit[cur.h][cur.n][cur.m] = true;

                for (int d = 0; d < 4; d++) {
                    int nn = cur.n + dn[d];
                    int nm = cur.m + dm[d];
                    if (isRange(cur.h, nn, nm) && map[cur.h][nn][nm] == 0 && dist[cur.h][nn][nm] == 0) {
                        visit[cur.h][nn][nm] = true;
                        dist[cur.h][nn][nm] = dist[cur.h][cur.n][cur.m] + 1;
                        queue.add(new Node(cur.h, nn, nm));
                    }
                }

                for (int d = 0; d < 2; d++) {
                    int nh = cur.h + dh[d];
                    if (isRange(nh, cur.n, cur.m) && map[nh][cur.n][cur.m] == 0 && dist[nh][cur.n][cur.m] == 0) {
                        visit[nh][cur.n][cur.m] = true;
                        dist[nh][cur.n][cur.m] = dist[cur.h][cur.n][cur.m] + 1;
                        queue.add(new Node(nh, cur.n, cur.m));
                    }
                }
            }


        }
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ans < dist[k][i][j])
                        ans = dist[k][i][j];
                }
            }
        }

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 0 && dist[k][i][j] == 0) {
                        ans = -1;
                    }
                }
            }
        }


        return ans;


    }


    static void print() {
        for (int i = 0; i < H; i++) {
            System.out.println(i + "층");
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.print(map[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }


    static boolean isRange(int h, int n, int m) {
        return 0 <= m && m < M && 0 <= n && n < N && 0 <= h && h < H;
    }

    static class Node {
        int h, n, m;


        public Node(int h, int n, int m) {
            this.h = h;

            this.n = n;
            this.m = m;
        }
    }
}
