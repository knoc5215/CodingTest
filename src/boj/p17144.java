package boj;

import java.util.*;

public class p17144 {
    static int ROW, COL, T;
    static int sum = 0;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};    // 동 북 서 남
    static int[] dy = {1, 0, -1, 0};

    static int[] dx2 = {0, 1, 0, -1};    // 동 북 서 남
    static int[] dy2 = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ROW = sc.nextInt();
        COL = sc.nextInt();
        T = sc.nextInt();

        map = new int[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        while (time < T) {

            diffusion();

            Topmove();

            Bottommove();

            time++;
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] != -1) {
                    sum += map[i][j];
                }
            }
        }

        System.out.println(sum);
    }

    public static void diffusion() {
        int[][] diffMap = new int[ROW][COL];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                int pos = map[i][j];

                if (pos == -1) {
                    diffMap[i][j] = pos;
                    continue;
                }
                if (pos == 0) {
                    continue;
                }

                int diffCount = 0;
                int diffVal = pos / 5;
                for (int k = 0; k < 4; k++) {
                    int nX = i + dx[k];
                    int nY = j + dy[k];

                    if (isRange(nX, nY) && map[nX][nY] != -1) {
                        diffCount++;
                        diffMap[nX][nY] += diffVal;
                    }
                }
                map[i][j] -= (diffVal * diffCount);
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (diffMap[i][j] != -1) {
                    map[i][j] += diffMap[i][j];
                }
            }
        }


    }

    public static void Topmove() {
        int wiperX = -1;
        int wiperY = -1;
        boolean flag = false;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == -1) {
                    wiperX = i;
                    wiperY = j;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        int dir = 0;

        int nX = wiperX;
        int nY = wiperY;
        Deque<Integer> deq = new LinkedList<>();
        while (true) {
            nX += dx[dir];
            nY += dy[dir];

            if (isRange(nX, nY)) {
                if (map[nX][nY] != -1) {
                    deq.add(map[nX][nY]);
                    map[nX][nY] = 0;
                } else {
                    break;
                }
            } else {
                nX -= dx[dir];
                nY -= dy[dir];
                if (dir < 4) {
                    dir++;
                } else {
                    dir = 0;
                }

                continue;
            }
        }

        int inX = wiperX;
        int inY = wiperY + 1;
        dir = 0;
        while (true) {

            if (deq.isEmpty()) {
                break;
            }

            inX += dx[dir];
            inY += dy[dir];

            if (isRange(inX, inY)) {
                if (map[inX][inY] != -1) {
                    map[inX][inY] = deq.poll();


                } else {
                    break;
                }
            } else {
                inX -= dx[dir];
                inY -= dy[dir];

                if (dir < 4) {
                    dir++;
                } else {
                    dir = 0;
                }

                continue;
            }


        }


    }

    public static void Bottommove() {
        int wiperX = -1;
        int wiperY = -1;
        boolean flag = false;
        for (int i = ROW - 1; i >= 0; i--) {
            for (int j = COL - 1; j >= 0; j--) {
                if (map[i][j] == -1) {
                    wiperX = i;
                    wiperY = j;
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }

        int dir = 0;

        int nX = wiperX;
        int nY = wiperY;
        Deque<Integer> deq = new LinkedList<>();
        while (true) {
            nX += dx2[dir];
            nY += dy2[dir];


            if (isRange(nX, nY)) {
                if (map[nX][nY] != -1) {
                    deq.add(map[nX][nY]);
                    map[nX][nY] = 0;
                } else {
                    break;
                }
            } else {
                nX -= dx2[dir];
                nY -= dy2[dir];
                if (dir < 4) {
                    dir++;
                } else {
                    dir = 0;
                }

                continue;
            }
        }


        int inX = wiperX;
        int inY = wiperY + 1;
        dir = 0;
        while (true) {

            if (deq.isEmpty()) {
                break;
            }

            inX += dx2[dir];
            inY += dy2[dir];

            if (isRange(inX, inY)) {
                if (map[inX][inY] != -1) {
                    map[inX][inY] = deq.poll();

                } else {
                    break;
                }
            } else {
                inX -= dx2[dir];
                inY -= dy2[dir];

                if (dir < 4) {
                    dir++;
                } else {
                    dir = 0;
                }

                continue;
            }

        }


    }

    public static boolean isRange(int x, int y) {
        return 0 <= x && x < ROW && 0 <= y && y < COL;
    }
}
