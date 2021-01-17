package boj;

import java.util.Scanner;

public class p1629 {
    static long A, B, C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();

        // 10을 11번 곱하고 12로 나눈 나머지
        System.out.println(power(A % C, B, C));


    }

    static long power(long a, long b, long c) {
        if (b == 1) {
            return a;
        } else {
            long temp = power(a, b / 2, c);
            if (b % 2 == 0) {
                return (temp * temp) % c;
            } else {
                return ((temp * temp) % c * a) % c;
            }
        }
    }
}
