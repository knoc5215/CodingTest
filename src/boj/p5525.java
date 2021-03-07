package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p5525 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        String S = bufferedReader.readLine();
        String pattern = makeIOI();

        List<Integer> list = kmp(S, pattern);
        System.out.println(list.size());


    }

    private static List<Integer> kmp(String str, String pattern) {
        List<Integer> list = new ArrayList<>();
        int[] pi = getPi(pattern);
        int j = 0;
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            while (j > 0 && s[i] != p[j]) {
                j = pi[j - 1];
            }

            if (s[i] == p[j]) {
                if (j == pattern.length() - 1) {
                    list.add(i - pattern.length() + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        return list;
    }

    private static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        char[] chars = pattern.toCharArray();
        int j = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = pi[j - 1];
            }
            if (chars[i] == chars[j]) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    private static String makeIOI() {
        StringBuilder stringBuilder = new StringBuilder("IOI");
        String oi = "OI";
        if (N > 1) {
            stringBuilder.append(oi.repeat(N - 1));
        }

        return stringBuilder.toString();
    }
}
