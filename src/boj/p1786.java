package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String pattern = br.readLine();

        List<Integer> list = kmp(input, pattern);
        bw.write(String.valueOf(list.size()));
        bw.newLine();
        for (int val : list) {
            int res = val + 1;
            bw.write(String.valueOf(res));
            bw.newLine();
        }

        bw.flush();

    }

    static List<Integer> kmp(String str, String pattern) {
        List<Integer> list = new ArrayList<>();
        int[] pi = getPi(pattern);
        int n = str.length();
        int m = pattern.length();
        int j = 0;

        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();

        for (int i = 0; i < n; i++) {
            // 중간 단계 뛰어넘기
            while (j > 0 && s[i] != p[j]) {
                // pi배열을 이용하여 j 인덱스를 변경시킴으로써 while 중단한다
                j = pi[j - 1];
            }

            if (s[i] == p[j]) {
                // j는 비교 인덱스로써, 인덱스가 찾을 문자열의 크기에 도달하면 찾은 것이다
                if (j == m - 1) {
                    // 여러 개의 찾을 문자열이 존재할 수 있다
                    list.add(i - m + 1);
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return list;
    }

    static int[] getPi(String pattern) {
        int m = pattern.length();
        int j = 0;
        char[] chars = pattern.toCharArray();
        int[] pi = new int[m];

        for (int i = 1; i < m; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = pi[j - 1];
            }
            if (chars[i] == chars[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
