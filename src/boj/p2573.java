package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p2573 {
    static int R, C;
    static int[][] map, height;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Node> queue;
    static boolean[][] visit;
    static int areaCnt;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        queue = new LinkedList<>();

        map = new int[R][C];
        height = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                int val = stoi(st.nextToken());
                map[i][j] = val;

                if (val > 0) {
                    queue.add(new Node(i, j));
                }
                j++;

            }
        }

        BFS();

        System.out.println(ans);
    }

    //동서남북 네 방향으로 붙어있는 0이 저장된 칸의 개수만큼 줄어든다.
    //한 덩어리의 빙산이 주어질 때, 이 빙산이 두 덩어리 이상으로 분리되는 최초의 시간(년)을 구하는 프로그램을 작성하시오.
    static void BFS() {
        int year = 0;
        while (!queue.isEmpty()) {

            //먼저 빙산부터 녹인다
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node cur = queue.poll();
                int waterHeight = map[cur.x][cur.y] - isWaterAdj(cur.x, cur.y); //상하좌우 계산
                if (waterHeight > 0) {  //아직 다 녹지 않았다면
                    height[cur.x][cur.y] = waterHeight;
                    queue.add(new Node(cur.x, cur.y));
                } else {
                    height[cur.x][cur.y] = 0;
                }
            }

            // 빙산이 얼마나 녹는가 기록한 배열을 원래 map으로 복사
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    map[i][j] = height[i][j];
                }
            }

            // 한 해 증가
            year++;

            //섬의 개수 초기화
            areaCnt = 0;
            visit = new boolean[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0 && !visit[i][j]) {    //섬이 존재하고, 아직 방문하지 않았다면
                        visit[i][j] = true;
                        areaCnt++;
                        search(i, j);   //섬 탐색
                    }
                }
            }

            // 최초로 섬이 2개 이상이 된다면
            if (areaCnt >= 2) {
                ans = year;
                return; // 반환하고 끝낸다
            }
        }


    }

    static void search(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (isRange(nx, ny) && !visit[nx][ny] && map[nx][ny] > 0) {
                    visit[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }

    static int isWaterAdj(int x, int y) {
        int cnt = 0;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isRange(nx, ny) && map[nx][ny] == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }


}
