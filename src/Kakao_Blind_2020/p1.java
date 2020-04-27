package Kakao_Blind_2020;

public class p1 {
    public static void main(String[] args) {
        String[] strings = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};

        for (String input : strings) {
            System.out.println("====================================");
            System.out.println(solution(input));
            System.out.println("====================================");
        }
    }

    // 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
    // aabbaccc --> 2a2ba3c --> 7
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int len = 1; len < s.length(); len++) {
            String target = "";
            String current = "";
            String result = "";

            int count = 1;

            for (int i = 0; i < len; i++) {
                target += s.charAt(i);
            }

            System.out.println("target = " + target);

            for (int i = len; i < s.length(); i += len) {
                current = "";
                for (int j = i; j < i + len; j++) {
                    if (j >= s.length()) {
                        break;
                    }
                    current += s.charAt(j);
                }

                System.out.println("\t currnet = " + current);

                if (target.equals(current)) {
                    System.out.println("\t\t equals --> " + target);
                    count++;
                } else {
                    if (count > 1) {
                        result += count + target;
                    } else {
                        result += target;
                    }
                    count = 1;
                    target = current;
                }
            }

            if (count > 1) {
                result += count + target;
            } else {
                result += target;
            }

            int length = result.length();
            answer = Math.min(answer, length);
        }

        if (answer == Integer.MAX_VALUE) {
            answer = 1;
        }


        return answer;
    }
}
