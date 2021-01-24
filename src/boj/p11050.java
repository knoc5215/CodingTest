package boj;

import java.util.Scanner;

public class p11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int ans = factorial(n) / (factorial(k) * factorial(n - k));
        System.out.println(ans);


    }

    static int factorial(int n) {
        int i = 1;
        for (int j = n; j >= 1; j--) {
            i *= j;
        }

        return i;
    }
}
