package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://pangsblog.tistory.com/53
public class p2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();

        // (()[[]])([])
        Stack<String> stack = new Stack<>();
        boolean isAble = true;  // 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다.

        for (int i = 0; i < string.length(); i++) {
            String cur = string.substring(i, i + 1);
            // 여는 괄호를 만나면, 본인의 닫는 괄호를 stack에 push
            if (cur.equals("(")) {
                stack.push(")");
            } else if (cur.equals("[")) {
                stack.push("]");
            } else {
                int num = 0;
                while (true) {
                    if (stack.isEmpty()) {  // 입력이 올바르지 못한 경우 (아직 본인 괄호가 나오지 않았는데 스택이 비었다면 올바르지 않은 경우)
                        isAble = false;
                        break;
                    }

                    if (isNumber(stack.peek())) {
                        num += Integer.parseInt(String.valueOf(stack.pop()));
                    } else {
                        if (isEqual(cur, stack.peek())) {   // 입력이 올바른 경우
                            stack.pop();
                            int temp = (cur.equals(")")) ? 2 : 3;

                            if (num == 0) {
                                stack.push(String.valueOf(temp));
                            } else {
                                stack.push(String.valueOf(temp * num));
                            }

                        } else {    // 본인과 맞지 않은 괄호가 나온다면 입력이 올바르지 않은 경우
                            isAble = false;
                        }
                        break;
                    }
                }
                if (!isAble) {
                    break;
                }
            }
        }

        int score = 0;
        while (!stack.isEmpty()) {  // 입력이 올바른 경우, 최종적으로 stack에는 score만 있어야 함
            if (isNumber(stack.peek())) {
                score += Integer.parseInt(stack.pop() + "");
            } else {
                isAble = false; // 입력이 올바르지 못한 경우
                break;
            }
        }

        if (isAble) {
            System.out.println(score);
        } else {
            System.out.println(0);
        }


    }

    private static boolean isEqual(String cur, String top) {
        return cur.equals(top);
    }

    private static boolean isNumber(String top) {
        return !(top.equals(")") || top.equals("]"));
    }


}
