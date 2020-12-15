package boj;

import java.util.Scanner;

public class p2475 {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            numbers[i] = sc.nextInt();
            sum += numbers[i] * numbers[i];
        }
        System.out.println(sum % 10);


    }
}
