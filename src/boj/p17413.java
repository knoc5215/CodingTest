package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class p17413 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        int len = input.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            // tag
            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                stack = new Stack<>();

                int closeIndex = findClose(i, input);
                String substring = input.substring(i, closeIndex + 1);
                sb.append(substring);
                i = i + substring.length() - 1;
            }
            // empty
            else if (ch == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                stack = new Stack<>();
                sb.append(" ");
                i = i + 1 - 1;
            }
            // 0-9, a-z
            else {
                stack.push(ch);
                if (i == len - 1) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
            }

        }

        System.out.println(sb);

    }

    public static int findClose(int index, String input) {
        int closeIndex = -1;
        for (int i = index + 1; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                closeIndex = i;
                break;
            }
        }

        return closeIndex;
    }
}
