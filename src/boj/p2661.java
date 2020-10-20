package boj;

import java.util.Scanner;

public class p2661 {
    static int n;
    static int[] arr;
    static boolean isEnd = false;
    static String ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n];

        backtracking("");
        System.out.println(ans);

    }

    static void backtracking(String str) {
        if (isEnd) return;

        if (str.length() == n) {
            ans = str;
            isEnd = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (isPossible(str + i))    // 1개~절반 까지 비교
                backtracking(str + i);
        }
    }

    static boolean isPossible(String str) {
        int len = str.length();

        for (int i = 1; i <= len / 2; i++) {
            String head = str.substring(str.length() - i * 2, str.length() - i);    // 절반 앞부분
            String tail = str.substring(str.length() - i);  // 절반 뒷부분

            if (head.equals(tail)) return false;
        }
        return true;
    }
}
