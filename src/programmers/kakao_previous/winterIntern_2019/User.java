package programmers.kakao_previous.winterIntern_2019;

import java.util.HashSet;

public class User {
    static HashSet<HashSet<String>> answerSet;
    static int bannedLen;
    static int userLen;
    static String[] userArr, bannedArr;
    static boolean[] visit;

    public static void main(String[] args) {

    }

    //당첨에서 제외되어야 할 제재 아이디 목록은 몇가지 경우의 수가 가능한 지 return 하도록 solution 함수를 완성해주세요.
    //순서와 관계없이 아이디 목록의 내용이 동일하다면 같은 것으로 처리하여 하나로 세면 됩니다.
    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        userLen = user_id.length;
        bannedLen = banned_id.length;
        userArr = user_id;
        bannedArr = banned_id;

        visit = new boolean[userLen];

        int index = 0;
        answerSet = new HashSet<>();
        DFS(index, new HashSet<>());

        answer = answerSet.size();

        return answer;
    }

    static void DFS(int index, HashSet<String> set) {
        if (index == bannedLen) {
            answerSet.add(set);
        } else {
            for (int i = 0; i < userLen; i++) {
                String user_id = userArr[i];
                if (match(bannedArr[index], user_id) && !visit[i]) {
                    visit[i] = true;
                    set.add(user_id);
                    DFS(index + 1, new HashSet<>(set));
                    // back tracking
                    visit[i] = false;
                    set.remove(user_id);
                }
            }
        }
    }

    static boolean match(String pattern, String id) {
        if (pattern.length() != id.length()) return false;
        else {
            int len = pattern.length();
            for (int i = 0; i < len; i++) {
                if (pattern.charAt(i) != '*') {
                    if (pattern.charAt(i) != id.charAt(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
