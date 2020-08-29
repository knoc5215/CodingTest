package programmers.kakao_previous.blind_2020;

/*
문자열 압축
압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.

abcabcabcabcdededededede

문자열을 2개 단위로 자르면 abcabcabcabc6de 가 됩니다.
문자열을 3개 단위로 자르면 4abcdededededede 가 됩니다.
문자열을 4개 단위로 자르면 abcabcabcabc3dede 가 됩니다.
문자열을 6개 단위로 자를 경우 2abcabc2dedede가 되며, 이때의 길이가 14로 가장 짧습니다.
 */
public class p1_2020 {
    public static void main(String[] args) {
        String s = "ababcdcdababcdcd";
        int ans = solution(s);
        System.out.println(ans);
    }


    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int len = 1; len < s.length(); len++) {
            StringBuilder compress = new StringBuilder();
            StringBuilder target = new StringBuilder();
            StringBuilder current;

            int count = 1;

            for (int i = 0; i < len; i++) {
                target.append(s.charAt(i));
            }

            for (int i = len; i < s.length(); i += len) {
                current = new StringBuilder();
                for (int j = i; j < i + len; j++) {
                    if (j >= s.length()) break;
                    current.append(s.charAt(j));
                }

                if (target.toString().equals(current.toString())) {
                    count++;
                } else {
                    if (count > 1) {
                        compress.append(count).append(target.toString());
                    } else {
                        compress.append(target);
                    }
                    count = 1;
                    target = new StringBuilder(current.toString());
                }
            }
            if (count > 1) {
                compress.append(count).append(target.toString());
            } else {
                compress.append(target);
            }
            answer = Math.min(answer, compress.length());
        }

        if (answer == Integer.MAX_VALUE) answer = 1;
        return answer;
    }
}
