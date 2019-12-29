package boj;

import java.util.*;

// 다시풀기
public class p17143 {
    static int R, C, M;
    static int sum = 0;
    static int[] dx = {-1, 1, 0, 0};   // 0북 1남 2동 3서
    static int[] dy = {0, 0, 1, -1};

    static Shark[] sharks = new Shark[10001];
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();

        map = new int[R + 1][C + 1];

        for (int i = 0; i < M; i++) {

            int row = sc.nextInt();
            int col = sc.nextInt();
            int speed = sc.nextInt();
            int dir = sc.nextInt();
            int size = sc.nextInt();

            Shark shark = new Shark(row, col, speed, dir - 1, size);
            sharks[size] = shark;
            map[row][col] = size;
        }


        for (int col = 1; col <= C; col++) {
            System.out.println();
            System.out.println("현재 위치=" + col);
            System.out.println();

            for (int row = 1; row <= R; row++) {
                if (map[row][col] != 0) {
                    sharks[map[row][col]] = null;
                    sum += map[row][col];
                    map[row][col] = 0;
                    break;
                }
            }

            for (int i = 1; i < 10001; i++) {
                if (sharks[i] == null) {
                    continue;
                }

                Shark shark = sharks[i];
                int nx = shark.r;
                int ny = shark.c;
                int s = shark.s;
                int dir = shark.d;

                System.out.println(shark.toString());
                map[nx][ny] = 0;

                switch (dir) {
                    case 0: // 북
                    case 1: // 남
                        s %= (R * 2 - 2);
                        while (s > 0) {
                            if (nx == 1) {
                                dir = 1;
                            }
                            if (nx == R) {
                                dir = 0;
                            }
                            nx += dx[dir];
                            s--;
                        }
                        sharks[shark.z] = new Shark(nx, ny, shark.s, dir, shark.z);
                        System.out.println("MOVE TO >> " + sharks[shark.z].toString());
                        break;

                    case 2: // 동
                    case 3: // 서
                        s %= (C * 2 - 2);
                        while (s > 0) {
                            if (ny == 1) {
                                dir = 2;
                            }
                            if (ny == C) {
                                dir = 3;
                            }
                            ny += dy[dir];
                            s--;
                        }
                        sharks[shark.z] = new Shark(nx, ny, shark.s, dir, shark.z);
                        System.out.println("MOVE TO >> " + sharks[shark.z].toString());
                        break;
                }
            }

            for (int i = 1; i < 10001; i++) {
                if (sharks[i] != null) {
                    Shark shark = sharks[i];

                    if (map[shark.r][shark.c] < shark.z) {
                        sharks[map[shark.r][shark.c]] = null;
                        map[shark.r][shark.c] = shark.z;
                    }
                }
            }
        }

        System.out.println(sum);


    }

    public static void kill() {
        for (int i = 1; i < 10001; i++) {
            if (sharks[i] != null) {
                Shark shark = sharks[i];

                if (map[shark.r][shark.c] < shark.s) {
                    int killed = map[shark.r][shark.c];

                    sharks[map[shark.r][shark.c]] = null;
                    map[shark.r][shark.c] = shark.s;

                    System.out.println(shark.toString() + " KILL " + killed);


                }
            }
        }
    }

    public static void moveShark() {
        for (int i = 1; i < 10001; i++) {
            if (sharks[i] == null) {
                continue;
            }

            Shark shark = sharks[i];
            int nx = shark.r;
            int ny = shark.c;
            int s = shark.s;
            int dir = shark.d;
            int size = shark.z;

            System.out.println(shark.toString());
            map[nx][ny] = 0;


            switch (dir) {
                case 0: // 북
                case 1: // 남

                    s %= (R * 2 - 2);
                    while (s > 0) {
                        if (nx == 1) {
                            dir = 2;
                        }
                        if (nx == R) {
                            dir = 1;
                        }
                        nx += dx[dir];
                        s--;
                    }
                    sharks[size] = new Shark(nx, ny, shark.s, dir, size);
                    System.out.println("MOVE TO >> " + sharks[size].toString());
                    break;
                case 2: // 동
                case 3: // 서
                    s %= (C * 2 - 2);
                    while (s > 0) {
                        if (ny == 1) {
                            dir = 3;
                        }
                        if (ny == C) {
                            dir = 4;
                        }
                        ny += dy[dir];
                        s--;
                    }
                    sharks[size] = new Shark(nx, ny, shark.s, dir, size);
                    System.out.println("MOVE TO >> " + sharks[size].toString());
                    break;
            }
        }
    }

    public static void catchShark(int col) {
        for (int row = 1; row <= R; row++) {
            if (map[row][col] != 0) {
                sharks[map[row][col]] = null;
                sum += map[row][col];
                map[row][col] = 0;
                break;
            }
        }
    }


    public static int dirConvert(int dir) {
        if (dir == 1) {
            return 2;
        } else if (dir == 2) {
            return 1;
        } else if (dir == 3) {
            return 4;
        } else {
            return 3;
        }

    }


    static class Shark {
        int r, c, s, d, z;

        @Override
        public String toString() {
            return "Shark{" +
                    "r=" + r +
                    ", c=" + c +
                    ", s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }


        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }


}
