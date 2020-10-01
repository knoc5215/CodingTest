package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p10870 {
    static int n;
    static List<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new ArrayList<>();

        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            while (true) {
                long fibNum = fib(n);
                list.add(fibNum);

                if (list.size() == n)
                    break;
            }

            System.out.println(list.get(n - 1));
        }
    }

    static long fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
