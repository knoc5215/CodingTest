package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p17779 {
    static int[][] map, tempMap;    // map = 입력배열, tempMap = 선거구 매기는 임시배열
    static int N;
    static int[] counts;    // 선거구별 누적합 배열
    static boolean[][] visit;   // 방문체크
    static List<Node> list = new ArrayList<>(); // 4개의 꼭지점 리스트
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int ans = Integer.MAX_VALUE; // 인구차이 최소값 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 4; i++) {
            list.add(new Node(0, 0));
        }

        for (int r = 0; r < N - 2; r++) {
            for (int c = 1; c < N - 1; c++) {
                for (int d1 = 1; d1 <= c; d1++) {
                    for (int d2 = 1; d2 < N - c; d2++) {
                        if (isRange(r, c, d1, d2)) {
                            list.set(0, new Node(r, c));    // 상단 꼭지점 좌표 갱신
                            list.set(1, new Node(r + d1, c - d1));  // 좌측 꼭지점 좌표 갱신
                            list.set(2, new Node(r + d2, c + d2));  // 우측 꼭지점 좌표 갱신
                            list.set(3, new Node(r + d2 + d1, c - d1 + d2));    // 하단 꼭지점 좌표 갱신

                            // 여기까지 오면 다이아몬드로 선거구 그리기 가능하니까

                            numbering();    // 1~5 선거구 번호 매기기 시작

                            counts = new int[6];    // 선거구별 인구 수 합 배열
                            visit = new boolean[N][N];  // 방문체크

                            // 선거구 번호마다 DFS 탐색
                            for (int i = 0; i < N; i++) {
                                for (int j = 0; j < N; j++) {
                                    if (!visit[i][j]) {
                                        DFS(i, j, tempMap[i][j]);
                                    }
                                }
                            }

                            int min = Integer.MAX_VALUE;
                            int max = Integer.MIN_VALUE;

                            for (int i = 1; i <= 5; i++) {
                                min = Math.min(min, counts[i]);
                                max = Math.max(max, counts[i]);
                            }

                            int dist = max - min;   // 선거구 인구 차이
                            ans = Math.min(ans, dist);  // 선거구 인구 차이 최소값

                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static void DFS(int x, int y, int value) {
        counts[value] += map[x][y]; // 선거구 번호별 누적합
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((0 <= nx && nx < N && 0 <= ny && ny < N) && !visit[nx][ny] && tempMap[nx][ny] == value) {
                DFS(nx, ny, value);
            }
        }

    }


    static void numbering() {
        tempMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = 5;  // 우선 전체를 5번 선거구로 매기고
            }
        }

        Node node1 = list.get(0);   // 상단 꼭지점 좌표
        Node node2 = list.get(1);   // 좌측 꼭지점 좌표
        Node node3 = list.get(2);   // 우측 꼭지점 좌표
        Node node4 = list.get(3);   // 하단 곡지점 좌표

        // 1번 선거구
        int temp = 0;
        for (int i = 0; i < node2.x; i++) { // 좌측 꼭지점의 바로 위까지만 돌면서
            if (node1.x <= i) temp++;   // 상단 꼭지점의 x좌표부터는 y끝범위가 1개씩 줄어든다
            for (int j = 0; j <= node1.y - temp; j++) {
                tempMap[i][j] = 1;
            }
        }

        // 2번 선거구
        temp = 0;
        for (int i = 0; i <= node3.x; i++) {    // 우측 꼭지점의 위치까지 돌면서
            if (node1.x < i) temp++;    // 상단 꼭지점의 x좌표보다 커지는 순간 y시작범위가 1개씩 늘어난
            for (int j = node1.y + 1 + temp; j < N; j++) {
                tempMap[i][j] = 2;
            }
        }

        // 3번 선거구
        temp = 0;
        for (int i = N - 1; i >= node2.x; i--) {    // 좌측 꼭지점의 위치까지 돌면서
            if (i < node4.x) temp++;    // 하단 꼭지점의 x좌표보다 작아지는 순간 y끝범위가 1개씩 줄어든다
            for (int j = 0; j < node4.y - temp; j++) {
                tempMap[i][j] = 3;
            }
        }

        // 4번 선거구
        temp = 0;
        for (int i = N - 1; i > node3.x; i--) { // 우측 꼭지점의 바로 아래까지만 돌면서
            if (i <= node4.x) temp++;   // 하단 꼭지점의 x좌표보다 작아지는 순간 y시작범위가 1개씩 늘어난다
            for (int j = node4.y + temp; j < N; j++) {
                tempMap[i][j] = 4;
            }
        }
    }

    static boolean isRange(int x, int y, int d1, int d2) {
        if (x + d1 >= N || y - d1 < 0) return false;
        if (x + d2 >= N || y + d2 >= N) return false;
        if (x + d1 + d2 >= N || y - d1 + d2 >= N) return false;
        if (x + d2 + d1 >= N || y + d2 - d1 < 0) return false;
        return true;
    }


    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
