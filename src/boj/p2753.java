package boj;

import java.util.Scanner;

public class p2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (isYoon(year)) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean isYoon(int year) {
        return ((year % 4 == 0 && (year % 100 != 0)) || year % 400 == 0);
    }
}
