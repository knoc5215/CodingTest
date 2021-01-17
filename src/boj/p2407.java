package boj;

import java.math.BigInteger;
import java.util.Scanner;

public class p2407 {
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        BigInteger ans = combination(n).divide(combination(m).multiply(combination(n - m)));
        System.out.println(ans);
    }

    static BigInteger combination(int n) {
        BigInteger multiple = BigInteger.valueOf(n);
        for (int i = n - 1; i >= 1; i--) {
            multiple = multiple.multiply(BigInteger.valueOf(i));
        }
        return multiple;
    }
}
