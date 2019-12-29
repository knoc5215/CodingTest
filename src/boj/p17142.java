package boj;

import java.util.*;

public class p17142 {
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map, check;
    static int emptySpace = 0;
    static int result = Integer.MAX_VALUE;
    static boolean[] VirusIndex;
    static List<Virus> virusList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        check = new int[N][N];
        VirusIndex = new boolean[10];
        virusList = new ArrayList<>();

        // 0 빈칸, 1 벽, 2 바이러스
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                } else if (map[i][j] == 0) {
                    emptySpace++;
                }
            }
        }

        activateVirus(0, 0);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);

    }

    public static void spreadVirus(Queue<Virus> queue) {
        int infectSpace = 0;
        int totalTime = 0;

        char[][] charMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = map[i][j];

                if (val == 0) {
                    charMap[i][j] = '0';    // 빈칸
                } else if (val == 1) {
                    charMap[i][j] = '-';    // 벽
                } else {
                    charMap[i][j] = '*';    // 비활성 바이러스
                }

            }
        }

        List<Virus> list = new ArrayList<>(queue);
        for (Virus obj : list) {
            charMap[obj.x][obj.y] = 'A';
            check[obj.x][obj.y] = 0;
        }

        while (!queue.isEmpty()) {
            Virus cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isRange(nx, ny)) continue; // 범위 벗어남
                if (check[nx][ny] != -1) continue; // 이미 지나감

                if (map[nx][ny] != 1) {
                    check[nx][ny] = check[cur.x][cur.y] + 1;    // 1초 증가해서 갱신
                    if (map[nx][ny] == 0) {
                        infectSpace++;
                        totalTime = check[nx][ny];
                    }
                    queue.add(new Virus(nx, ny));

                }
            }
        }

        if (infectSpace == emptySpace) {
            result = Math.min(result, totalTime);
        }

    }


    public static void activateVirus(int cnt, int idx) {
        if (cnt == M) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(check[i], -1);
            }

            Queue<Virus> queue = new LinkedList<>();
            for (int i = 0; i < virusList.size(); i++) {
                if (VirusIndex[i]) {
                    Virus virus = virusList.get(i);
                    queue.add(virus);
                    check[virus.x][virus.y] = 0;
                }
            }

            spreadVirus(queue);
            return;
        }

        for (int i = idx; i < virusList.size(); i++) {
            if (!VirusIndex[i]) {
                VirusIndex[i] = true;
                activateVirus(cnt + 1, i + 1);
                VirusIndex[i] = false;
            }
        }

    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }


    static class Virus {
        int x, y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}
