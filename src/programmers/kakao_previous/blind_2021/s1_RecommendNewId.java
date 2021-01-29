package programmers.kakao_previous.blind_2021;

/*
규칙에 맞지 않는 아이디를 입력했을 때, 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천

 */
public class s1_RecommendNewId {
    public static void main(String[] args) {
        String new_id = "abcdefghijklmn.p";
        String[] arr = {
                "...!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=", "123_.def", "abcdefghijklmn.p"
        };

        for (String str : arr) {
            String ans = solution(str);
            System.out.println(ans);

        }


    }

    //7단계의 처리 과정을 거친 후의 추천 아이디를 return
    public static String solution(String new_id) {
        String id = new_id.toLowerCase();   //1단계 소문자
        id = grade2(id);    // 2단계 제거
        id = grade3(id);
        id = grade4(id);

        if (id.length() < 1) {
            id = "a";
        }
        id = grade6(id);
        if (id.charAt(id.length() - 1) == '.') {
            id = grade4(id);
        }
        id = grade7(id);
//        System.out.println("7단계 ->" + id);

        String answer = id;
        return answer;
    }

    static String grade7(String id) {
        if (id.length() <= 2) {
            int len = id.length();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(id);
            char lastCh = id.charAt(id.length() - 1);
            for (int i = 0; i < 3 - len; i++) {
                stringBuilder.append(lastCh);
            }

            return stringBuilder.toString();
        } else
            return id;
    }


    static String grade6(String id) {
        if (id.length() >= 16) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 15; i++) {
                stringBuilder.append(id.charAt(i));
            }
            return stringBuilder.toString();
        } else
            return id;
    }

    static String grade4(String id) {
        char[] chars = id.toCharArray();
        char front = chars[0];
        char tail = chars[chars.length - 1];

        if (front == '.') {
            chars[0] = ' ';
        }

        if (tail == '.') {
            chars[chars.length - 1] = ' ';
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                stringBuilder.append(chars[i]);
            }
        }

        return stringBuilder.toString();
    }

    static String grade2(String id) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            char ch = id.charAt(i);
            if (isAlphabet(ch) || isNum(ch) || ch == '-' || ch == '_' || ch == '.') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    static String grade3(String id) {
        char[] chars = id.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '.') {
                for (int j = i + 1; j < chars.length; j++) {
                    char nextCh = chars[j];
                    if (nextCh == '.') {
                        chars[j] = ' ';
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                stringBuilder.append(chars[i]);
            }
        }

        return stringBuilder.toString();
    }

    static boolean isAlphabet(char ch) {
        return 'a' <= ch && ch <= 'z';
    }

    static boolean isNum(char ch) {
        return '0' <= ch && ch <= '9';
    }


}
