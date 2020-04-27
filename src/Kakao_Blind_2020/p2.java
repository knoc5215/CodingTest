package Kakao_Blind_2020;

import java.util.Stack;

/*
     '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열
      괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열
 */
public class p2 {

    public static void main(String[] args) {

        String[] strings = {"(()())()", ")(", "()))((()"};
        for (String str : strings) {
//            System.out.println("current : " + str);
            System.out.println("answer : " + solution(str));
//            System.out.println("===================================");

        }

    }


    public static String solution(String param) {
        String result = "";

        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환
        if (param.length() < 1) {
            return result;
        }

        // 이미 올바른 문자열인 경우, 그대로 반환
        if (isProper(param)) {
//            System.out.println("이미 올바른 문자열 >>" + param);
            result = param;
            return result;
        }

        String u = "";
        String v = "";

        StringBuffer sb;
        for (int i = 0; i < param.length(); i++) {
            sb = new StringBuffer();
            for (int j = 0; j <= i; j++) {
                sb.append(param.charAt(j));
            }
            u = sb.toString();

            sb = new StringBuffer();
            for (int j = i + 1; j < param.length(); j++) {
                sb.append(param.charAt(j));
            }
            v = sb.toString();


            // 균형잡힌 && 올바른 문자열

            if (isBalanced(u) && isProper(u)) {
                // v에 대해 재귀
                String recurssion = solution(v);
                // 수행한 결과 문자열을 u에 이어 붙인 후 반환
                result = u + recurssion;
                return result;

                // 올바른 문자열이 아니라면
            } else if (isBalanced(u) && !isProper(u)) {

                String temp = "";
                temp += "(";     // 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                String recurssion = solution(v);    // 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
                temp += recurssion;
                temp += ")";    // ')'를 다시 붙입니다.


                StringBuffer splitHeadAndTail = new StringBuffer();
                StringBuffer reverse = new StringBuffer();

                for (int j = 0; j < u.length(); j++) {
                    if (j == 0 || j == u.length() - 1) {    // u의 첫 번째와 마지막 문자를 제거하고
                        continue;
                    } else {
                        splitHeadAndTail.append(u.charAt(j));
                    }
                }

                for (int j = 0; j < splitHeadAndTail.toString().length(); j++) {  // 나머지 문자열의 괄호 방향을 뒤집어서
                    char ch = splitHeadAndTail.toString().charAt(j);
                    if (ch == '(') {
                        reverse.append(')');
                    } else {
                        reverse.append('(');
                    }
                }
                temp += reverse.toString(); // 뒤에 붙입니다.
                result = temp;  // 생성된 문자열을 반환합니다.
                return result;
            }
        }
        return result;
    }

    //  '(' 의 개수와 ')' 의 개수가 같다면 이를 균형잡힌 괄호 문자열
    public static boolean isBalanced(String str) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
        }
        if (left == right) {
            return true;
        } else {
            return false;
        }
    }

    //  괄호의 짝도 모두 맞을 경우에는 이를 올바른 괄호 문자열
    public static boolean isProper(String str) {
        Stack<Character> leftStack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                leftStack.push(ch);
            } else {
                if (leftStack.size() < 1) {
                    return false;
                } else {
                    leftStack.pop();
                }
            }
        }

        if (leftStack.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}
