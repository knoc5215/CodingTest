package boj;

import java.util.Scanner;

public class p10162 {
    public static final int A = 60 * 5;
    public static final int B = 60;
    public static final int C = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int time = sc.nextInt();

        int[] cnt = new int[3];
        int clickCnt;
        while (time > 0) {
            clickCnt = 0;
            if (time / A > 0) {
                cnt[0] += time / A;
                time -= A * (time / A);
                clickCnt++;
            }

            if (time / B > 0) {
                cnt[1] += time / B;
                time -= B * (time / B);
                clickCnt++;
            }

            if (time / C > 0) {
                cnt[2] += time / C;
                time -= C * (time / C);
                clickCnt++;
            }

            if (clickCnt < 1) {
                System.out.println(-1);
                return;
            }

        }
        for (int i : cnt) {
            System.out.print(i + " ");
        }
    }
}
