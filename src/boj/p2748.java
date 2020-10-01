package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2748 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Long> fibList = new ArrayList<>(); // 범위 주의 long으로 해야함
        fibList.add((long) 0);
        fibList.add((long) 1);
        if (n >= 2) {   // 피보나치 동작 조건
            do {
                int size = fibList.size();
                long next = fibList.get(size - 2) + fibList.get(size - 1);
                fibList.add(next);

            } while (fibList.size() != n + 1);
            System.out.println(fibList.get(fibList.size() - 1));
        } else {
            System.out.println(n);
        }


    }


}
