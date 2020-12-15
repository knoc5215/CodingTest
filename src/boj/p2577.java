package boj;

import java.util.Scanner;

public class p2577 {
    static int[] counter = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numToStr = String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt());
        for (int i = 0; i < numToStr.length(); i++) {
            counter[Integer.parseInt(numToStr.charAt(i) + "")]++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(counter[i]);
        }
    }
}
