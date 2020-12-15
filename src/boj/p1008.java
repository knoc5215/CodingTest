package boj;

import java.util.Scanner;

public class p1008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        System.out.println(Math.round((a/b)*100000000)/100000000.0);
    }
}
