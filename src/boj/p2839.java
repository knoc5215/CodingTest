package boj;

import java.util.Scanner;

public class p2839 {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int five = 0;
        int three = 0;

        if (n % 5 == 0) {   // 5의 배수면
            five = n / 5;
            System.out.println(five);   // 딱 나누어 떨어진다
        } else {
            while (n % 5 != 0 && n >= 0) {  // ex) n = 11
                n -= 3; // n = 5    // 5kg 남아있음
                three++;    // three = 2 (3kg * 2 = 6kg) 3키로 봉지 2개
            }
            if (n < 0) {    // ex) n = 7 일때, 딱 맞게 나눌 수 없음
                System.out.println(-1); // 종료

            } else {
                five = n / 5;
                System.out.println(five + three);
            }

        }


    }
}
