package boj;

import java.util.Scanner;

public class p1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        for (int i = m; i <= n; i++) {
            if (isPrimeNumber(i)) System.out.println(i);
        }
    }

    public static boolean isPrimeNumber(int number) {
        if(number<2) {
            return false;
        }
        for (int i = 2; i*i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
