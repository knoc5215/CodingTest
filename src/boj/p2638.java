package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
입력으로 주어진 치즈가 모두 녹아 없어지는데 걸리는 정확한 시간을 구하는 프로그램을 작성하시오.
 */
public class p2638 {
    static int R, C;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = 0;
    static int cheeze;  // 총 치즈 카운트
    static boolean[][] visit;   // 방문체크
    static boolean[][] check;   // 치즈인지
    static boolean[][] adjTwo;  // 제거가능한 치즈인지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = stoi(st.nextToken());
        C = stoi(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                int val = stoi(st.nextToken());
                map[i][j++] = val;
                if (val == 1) cheeze++;
            }
        }

        int time = 0;
        while (cheeze != 0) {
            time++;
            check();    // 제거대상치즈 체크
            delete();   // 제거
        }
        ans = time;
        System.out.println(ans);
    }

    // 말 그대로 치즈인지만 체크
    static void check() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        visit = new boolean[R][C];  // 방문 체크 배열
        visit[0][0] = true; // 00부터 시

        check = new boolean[R][C];  // 치즈 체크 배열
        adjTwo = new boolean[R][C]; // 제거가능한 치즈인지 체크 배열

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isRange(nx, ny)) continue;
                if (visit[nx][ny]) continue;

                if (map[nx][ny] == 0) { // 공기 노드 추가
                    queue.add(new Node(nx, ny));
                } else {    // 치즈라면
                    check[nx][ny] = true;   // 치즈라고 check함
                }

                visit[nx][ny] = true;   // 방문체크
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (check[i][j]) {  // 치즈라고 check된 것들중에
                    int adjCnt = moreThanTwo(i, j); // 적어도 2변 이상이 공기와 접촉했는지
                    if (adjCnt >= 2) {   // 접촉변이 2개 이상이라면
                        adjTwo[i][j] = true;    // 제거가능한 치즈라고 체크
                    }
                }
            }
        }


    }

    // 제거가능한 치즈를 실제로 제거하자
    static void delete() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (adjTwo[i][j]) { // 제거대상이면
                    map[i][j] = 0;  //제거한다
                    cheeze--;   // 전체 치즈 카운트 감소
                }
            }
        }
    }

    // 접촉변이 몇개인지
    static int moreThanTwo(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isRange(nx, ny) && map[nx][ny] == 0 && visit[nx][ny]) { // 공기면서, 외부공기라면
                cnt++;
            }
        }

        return cnt;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
