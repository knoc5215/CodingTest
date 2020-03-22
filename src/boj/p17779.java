package boj;

import java.util.Arrays;
import java.util.Scanner;

/*
    삼성 SW역테 : 게리멘더링 2
    d1, d2 ≥ 1, 1 ≤ x < x+d1+d2 ≤ N, 1 ≤ y-d1 < y < y+d2 ≤ N
 */
public class p17779 {
    static int[][] map, people;
    static int ret = Integer.MAX_VALUE;
    static int N;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        people = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                people[i][j] = sc.nextInt();
            }
        }

        run();

    }

    public static void run() {
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 < N * 2; d1++) {
                    for (int d2 = 1; d2 < N * 2; d2++) {
                        if (x + d1 + d2 <= N && 1 <= y - d1 && y + d2 <= N) {

                            sum1(x, y, d1, d2);
                            sum2(x, y, d1, d2);
                            sum3(x, y, d1, d2);
                            sum4(x, y, d1, d2);

                            sum5(x, y, d1, d2);

                            printMap();

                            count();

                        }
                    }
                }
            }
        }
        System.out.println(ret);
    }


    /*
        첫째 줄에 인구가 가장 많은 선거구와 가장 적은 선거구의 인구 차이의 최솟값을 출력한다.
     */
    public static void count() {
        int[] counts = new int[6];

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                counts[map[r][c]] += people[r][c];
                //people[r][c] = 1;
            }
        }


        Arrays.sort(counts);
        int diff = counts[5] - counts[1];


        ret = Math.min(ret, diff);


    }

    // 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
    public static void sum1(int x, int y, int d1, int d2) {
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                map[r][c] = 1;
            }
        }
    }

    // 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
    public static void sum2(int x, int y, int d1, int d2) {
        for (int r = 1; r <= x + d2; r++) {
            for (int c = y + 1; c <= N; c++) {
                map[r][c] = 2;
            }
        }
    }

    // 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
    public static void sum3(int x, int y, int d1, int d2) {
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                map[r][c] = 3;
            }
        }
    }

    // 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
    public static void sum4(int x, int y, int d1, int d2) {
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = y - d1 + d2; c <= N; c++) {
                map[r][c] = 4;
            }
        }
    }

    public static void sum5(int x, int y, int d1, int d2) {
        for (int a = 0; a <= d1; a++) {
            map[x + a][y - a] = 5;
        }

        for (int a = 0; a <= d2; a++) {
            map[x + a][y + a] = 5;
        }

        for (int a = 0; a <= d2; a++) {
            map[x + d1 + a][y - d1 + a] = 5;
        }

        for (int a = 0; a <= d1; a++) {
            map[x + d2 + a][y + d2 - a] = 5;
        }

        for (int a = 0; a < d1; a++) {
            inner5(x + a + 1, y - a);
        }

        for (int a = 0; a < d2; a++) {
            inner5(x + a + 1, y + a);
        }


    }

    public static void inner5(int x, int y) {
        map[x][y] = 5;

        int nx, ny;
        for (int dir = 0; dir < 4; dir++) {
            nx = x + direction[dir][1];
            ny = y + direction[dir][0];
            if ((nx > 0) && (nx <= N) && (map[nx][ny] != 5) && (ny > 0) && (ny <= N)) {
                inner5(nx, ny);
            }

        }
    }

    public static void printMap() {
        System.out.println("===================================================");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===================================================");
    }


}
