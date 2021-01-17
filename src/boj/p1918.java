package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p1918 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        int len = input.length();

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);

            if (isAlphabet(ch)) {   // 알파벳이면 출력
                sb.append(ch);
            } else {
                if (ch == '(') {    // open push
                    stack.push(ch);
                } else if (ch == ')') { // closed 만나면
                    while (!stack.isEmpty()) {  // open직전까지 출력
                        char top = stack.pop();
                        if (top == '(') break;  // open을 만나면 break
                        sb.append(top);
                    }
                } else {    // 연산자일떄
                    while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)) {  // 스택의 top보다 현재 문자가 우선순위가 큰 경우에만 스택에 push
                        sb.append(stack.pop()); // 아니라면 출력
                    }
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()); // 쌓인거 다 출력
        }

        System.out.println(sb);


    }


    static int getPriority(char ch) {
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }

    static boolean isAlphabet(char ch) {
        return 'A' <= ch && ch <= 'Z';
    }
}
