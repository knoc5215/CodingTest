package kakao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class p3 {
    static int ret = 0;
    static boolean[] visit;
    static Set<String> set, checkSet;

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        int ans = solution(user_id, banned_id);


        System.out.println("ret > " + ans);
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        for (int i = 0; i < banned_id.length; i++) {
            String banId = banned_id[i];

            for (int j = 0; j < user_id.length; j++) {
                String userId = user_id[j];
//                System.out.println("현재 userID = " + userId + ", banID = " + banId);
                if (userId.length() == banId.length() && isBanned(banId, userId)) {
                    System.out.println(userId + "와 " + banId + "는 일치합니다.");
                    checkSet.add(userId);
                    break;

                }
            }

        }


        return answer;
    }

    static boolean check(String[] banned_id) {

        checkSet = new HashSet<>();

        int check = 0;

        String[] users = new String[set.size()];
        int idx = 0;
        for (String id : set) {
            users[idx++] = id;
        }

        for (int i = 0; i < banned_id.length; i++) {
            String banId = banned_id[i];

            for (int j = 0; j < users.length; j++) {
                String userId = users[j];
//                System.out.println("현재 userID = " + userId + ", banID = " + banId);
                if (userId.length() == banId.length() && isBanned(banId, userId)) {
                    System.out.println(userId + "와 " + banId + "는 일치합니다.");
                    check++;
                    checkSet.add(userId);
                    break;

                }
            }

        }


        System.out.println("check is " + check);

        return check == set.size();

    }

    static void run(int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {
            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 경우의 수 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            set = new HashSet<>();
            for (int i = 0; i < visit.length; i++) {
                System.out.print(visit[i] == true ? user_id[i] + " " : "");
                if (visit[i]) {
                    set.add(user_id[i]);
                }
            }
            System.out.println();

            if (check(banned_id)) {
                ret++;
            }

        }

        for (int i = 0; i < user_id.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                run(depth + 1, user_id, banned_id);
                visit[i] = false;
            }
        }
    }

    static boolean isBanned(String banId, String userId) {
        for (int i = 0; i < banId.length(); i++) {
            if (!(banId.charAt(i) == userId.charAt(i) || banId.charAt(i) == '*')) {
                return false;
            }

        }

        return true;
    }
}
