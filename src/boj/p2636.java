package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
공기 중에서 치즈가 모두 녹아 없어지는 데 걸리는 시간과
모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수를 구하는 프로그램을 작성하시오.
 */
public class p2636 {
    static int R, C;
    static int[][] map, checkMap;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int zeroTime = 0;
    static int cheeze = 0;
    static List<Integer> remainList = new ArrayList<>();
    static boolean[][] melt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new int[R][C];
        melt = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 1) {
                    cheeze++;   // 치즈갯수 카운트
                }
                j++;
            }
        }

        int prev = 0;

        while (cheeze != 0) {
            prev = cheeze;  // 직전 치즈 저장
            zeroTime++;
            check();    // 녹을 곳 체크
            delete();   // 녹임
        }

        System.out.println(zeroTime);
        System.out.println(prev);


    }

    private static void delete() {
        boolean[][] visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isEdge(i, j)) { // 바깥이라면
                    visit[i][j] = true;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visit[i][j]) {
                    if (map[i][j] == 1) {   // 치즈 증발
                        cheeze--;
                    }
                    map[i][j] = 0;
                    melt[i][j] = true;  // 녹음 체크
                }

            }
        }
    }

    public static boolean isEdge(int x, int y) {


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx, ny) && melt[nx][ny]) {  //melt true는 치즈 바깥 빈공간만 체크되어있다
                return true;
            }
        }
        return false;
    }

    public static void check() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        boolean[][] visit = new boolean[R][C];
        visit[0][0] = true;
        melt[0][0] = true;

        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int k = 0; k < qSize; k++) {
                Node cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (isRange(nx, ny) && map[nx][ny] == 0 && !visit[nx][ny]) {
                        queue.add(new Node(nx, ny));
                        visit[nx][ny] = true;
                        melt[nx][ny] = true;    // 녹여도 된다
                    }
                }

            }
        }

    }


    public static boolean isRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    public static void printMap() {
        System.out.println("===============printMap================");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
