package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p9935 {
    static String str;
    static String exploding;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        exploding = br.readLine();
        int len = exploding.length();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= len) {  // 폭발문자열 사이즈보다 크다면
                boolean flag = true;
                for (int j = 0; j < len; j++) {
                    if (stack.get(stack.size() - len + j) != exploding.charAt(j)) { // 다르면
                        flag = false;
                        break;  // 종료
                    }
                }
                if (flag) {
                    for (int j = 0; j < len; j++) { // 폭발문자열 길이만큼 pop
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : stack) { // 폭발문자열을 제외한 나머지가 남는다
            sb.append(character);
        }

        System.out.println(sb.length() > 0 ? sb : "FRULA");
    }

/*      char[]를 이용한 방법

        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        exploding = br.readLine();

        int idx = 0;
        int len;
        char[] ans = new char[1000001];
        char[] bomb = new char[37];
        for (int i = 0; i < exploding.length(); i++) {
            bomb[i] = exploding.charAt(i);
        }
        len = exploding.length();

        for (int i = 0; i < str.length(); i++) {
            ans[idx++] = str.charAt(i);
            if (ans[idx - 1] == bomb[len - 1]) {
                if (idx >= len) {
                    boolean flag = false;
                    for (int j = 0; j < len; j++) {
                        if (ans[idx - 1 - j] != bomb[len - 1 - j]) {
                            flag = true;
                            break;
                        }
                    }

                    if (!flag) {
                        idx -= len;
                    }
                }
            }
        }

        if (idx == 0) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idx; i++) {
                sb.append(ans[i]);
            }
            System.out.println(sb);
        }
    }*/
}
