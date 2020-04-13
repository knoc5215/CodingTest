package swea;

import java.util.Scanner;

public class p1217_Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println("#" + T + " " + power(N,M));
        }
    }

    static int power(int n, int m) {
        int start = n;

        while (m>1) {
//            System.out.println("현재 " + start);
            start *= n;
            m--;
        }

        return start;
    }
}
