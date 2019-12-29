package boj;

import java.util.*;

public class p16236 {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] check;
    static int sharkX, sharkY, minDist, minX, minY, eatCnt, result = 0, sharkSize = 2;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        check = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            minDist = Integer.MAX_VALUE;
            minX = 21;
            minY = 21;

            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    check[i][j] = -1;
                }
            }

            BFS(sharkX, sharkY);

            if (minX != 21 && minY != 21) {
                result += check[minX][minY];
                eatCnt++;

                if (sharkSize == eatCnt) {
                    sharkSize++;
                    eatCnt = 0;
                }

                map[minX][minY] = 0;

                sharkX = minX;
                sharkY = minY;
            } else {
                break;
            }

        }

        System.out.println(result);


    }

    public static void BFS(int x, int y) {
        Queue<Fish> queue = new LinkedList<>();
        check[x][y] = 0;
        queue.add(new Fish(x, y));

        while (!queue.isEmpty()) {
            Fish current = queue.poll();
            x = current.x;
            y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isRange(nx, ny)) continue; // 범위 초과
                if (map[nx][ny] > sharkSize) continue;  // 물고기가 더 크면 못간다
                if (check[nx][ny] != -1) continue;  // 이미 방문했거나

                check[nx][ny] = check[x][y] + 1;    // 이동거리 갱신

                if (map[nx][ny] != 0 && map[nx][ny] < sharkSize) {   // 먹을 수 있는 물고기라면
                    if (minDist > check[nx][ny]) {
                        minDist = check[nx][ny];
                        minX = nx;
                        minY = ny;
                    } else if (minDist == check[nx][ny]) {
                        if (minX == nx) {   // 가장 위쪽에 있다면?
                            if (minY > ny) {    // 가장 왼쪽에 있는지?
                                minX = nx;
                                minY = ny;
                            }
                        } else if (minX > nx) {
                            minX = nx;
                            minY = ny;
                        }
                    }
                }
                queue.add(new Fish(nx, ny));
            }
        }

    }


    public static boolean isRange(int x, int y) {
        return 0 <= x && x < N + 1 && 0 <= y && y < N + 1;
    }

    static class Fish {
        int x, y;

        public Fish(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
