package boj;

import java.util.Scanner;

public class p2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 1;
        int i = 1;
        int count = 1;
        if (n > 1) {
            while (sum < n) {
                count++;
                sum += (i++) * 6;
            }
        }
        System.out.println(count);
    }
}
