package boj;

import java.util.Scanner;

public class p1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }

            System.out.println(isPalindrome(n) ? "yes" : "no");


        }

    }

    static boolean isPalindrome(int n) {
        String str = n + "";
        StringBuilder ascend = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            ascend.append(str.charAt(i));
        }

        StringBuilder descend = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            descend.append(str.charAt(i));
        }

        return ascend.toString().equals(descend.toString());
    }

}
