package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class p4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = bufferedReader.readLine();
            if (str.length() == 1 && str.charAt(0) == '.') {
                break;
            }
            str = replace(str); // 공백 및 괄호가 아닌 문자 제거

            if (str.length() == 0) {    // 괄호가 없는 빈 문자열도 균형잡힌 문자열로 취급한다
                System.out.println("yes");
            } else {    // 남아있는 문자가 있을 경우
                Stack<String> stack = new Stack<>();
                boolean isAble = true;
                for (int i = 0; i < str.length(); i++) {
                    String cur = str.substring(i, i + 1);
                    if (cur.equals("(") || cur.equals("[")) {   // 여는 괄호라면 stack에 push
                        stack.push(cur);
                    } else {    // 닫는 괄호일 경우
                        if (stack.size() == 0) {    // 닫는 괄호가 나왔는데, stack이 비어있다는 것은 여는 괄호가 등장하지 않았다는 것이고 유효하지 않은 경우이다
                            isAble = false;
                            break;
                        }
                        String top = stack.peek();
                        if (cur.equals(")")) {  // )닫는 괄호의 경우
                            if (stack.isEmpty() || !"(".equals(stack.peek())) { // 스택이 비어있거나, top이 [ 라면
                                isAble = false; // 유효하지 않은 경우
                                break;
                            } else {
                                stack.pop();    // 짝이 맞는 경우
                            }
                        } else if (cur.equals("]")) {   // ]닫는 괄호의 경우
                            if (stack.isEmpty() || !"[".equals(stack.peek())) { // 스택이 비어있거나, top이 ( 라면
                                isAble = false; // 유효하지 않은 경우
                                break;
                            } else {
                                stack.pop();    // 짝이 맞는 경우
                            }
                        }
                    }
                }

                if (!isAble) {  // 유효하지 않은 경우
                    System.out.println("no");
                } else {
                    if (stack.isEmpty()) {  // 스택이 비어있어야 유효한 괄호문자열이다
                        System.out.println("yes");
                    } else {        // 남아있으면 유효하지 않은 괄호문자열이다
                        System.out.println("no");
                    }
                }
            }
        }
    }

    private static String replace(String str) {
        str = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '[' || str.charAt(i) == ']') {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


}
