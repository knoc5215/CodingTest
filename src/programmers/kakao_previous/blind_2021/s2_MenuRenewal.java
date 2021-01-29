package programmers.kakao_previous.blind_2021;

import java.util.*;

public class s2_MenuRenewal {
    static Map<String, Integer[]> map = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        String[] ans = solution(orders, course);
        for (String val : ans) {
            System.out.print(val + " ");
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> arrayList = new ArrayList<>();

        for (int s = 0; s < orders.length; s++) {
            String str = orders[s];

            for (int i = 2; i <= str.length(); i++) {
                char[] chars = str.toCharArray();
                boolean[] visit = new boolean[chars.length];
                int start = 0;
                int n = chars.length;

                combination(orders.length, s, chars, visit, start, n, i);
            }
        }

        Iterator<String> itr = map.keySet().iterator();
        List<Node> list = new ArrayList<>();
        while (itr.hasNext()) {
            String key = itr.next();
            Integer[] arr = map.get(key);
            int using = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    using++;    // 2명 이상의 손님으로부터 주문된 조합에 대해서만
                }
            }
            if (using >= 2) {
                Node node = new Node(key, using);
                list.add(node);
            }
        }


        list.sort((o1, o2) -> {
            if (o1.str.length() == o2.str.length()) {
                return o1.cnt - o2.cnt;
            } else {
                return o1.str.length() - o2.str.length();
            }
        });

        for (int i = 0; i < course.length; i++) {
            int courseCnt = course[i];
            List<Node> courseList = findCourseByCnt(list, courseCnt);
            for (Node node : courseList) {
                arrayList.add(node.str);
            }
        }

        Collections.sort(arrayList);
        answer = new String[arrayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    private static List<Node> findCourseByCnt(List<Node> list, int courseCnt) {
        List<Node> resultList = new ArrayList<>();
        int MAX = Integer.MIN_VALUE;
        for (Node node : list) {
            if (node.str.length() == courseCnt) {
                MAX = Math.max(MAX, node.cnt);
                resultList.add(node);
            }
        }

        List<Node> returnList = new ArrayList<>();
        for (Node node : resultList) {
            if (node.cnt == MAX) {
                returnList.add(node);
            }
        }
        return returnList;
    }

    private static void combination(int len, int index, char[] chars, boolean[] visit, int start, int n, int r) {
        if (r == 0) {
            String menu = getCombiMenu(chars, visit, n);
            if (!map.containsKey(menu)) {
                Integer[] arr = new Integer[len];
                Arrays.fill(arr, 0);
                arr[index]++;
                map.put(menu, arr);

            } else {
                Integer[] arr = map.get(menu);
                arr[index]++;
                map.put(menu, arr);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            combination(len, index, chars, visit, i + 1, n, r - 1);
            visit[i] = false;
        }

    }

    private static String getCombiMenu(char[] chars, boolean[] visit, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(chars);
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                stringBuilder.append(chars[i]);
            }
        }

        return stringBuilder.toString();
    }

    static class Node {
        public String str;
        public int cnt;

        public Node(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }


}
