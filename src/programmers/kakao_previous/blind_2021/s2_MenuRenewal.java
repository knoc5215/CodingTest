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
        String[] answer;
        ArrayList<String> arrayList = new ArrayList<>();

        for (int s = 0; s < orders.length; s++) {
            String str = orders[s];

            // s번 손님이 주문한 단푼 메뉴 조합에 대해서
            for (int i = 2; i <= str.length(); i++) {
                char[] chars = str.toCharArray();
                boolean[] visit = new boolean[chars.length];
                int start = 0;
                int n = chars.length;
                // 최소 2가지 이상의 단품메뉴로 구성하기 위함
                combination(orders.length, s, chars, visit, start, n, i);
            }
        }

        Iterator<String> itr = map.keySet().iterator();
        List<Node> list = new ArrayList<>();
        while (itr.hasNext()) {
            String key = itr.next();    // 조합된 메뉴
            Integer[] arr = map.get(key);   // 조합된 메뉴가 각 손님으로부터 주문된 조합인지 체크
            int using = 0;
            for (Integer integer : arr) {
                if (integer > 0) {
                    using++;
                }
            }
            if (using >= 2) {
                Node node = new Node(key, using);   // 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 코스요리 메뉴 후보에 포함
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

        // 코스 메뉴 개수마다
        for (int courseCnt : course) {
            List<Node> courseList = findCourseByCnt(list, courseCnt);   //
            for (Node node : courseList) {
                arrayList.add(node.str);
            }
        }

        Collections.sort(arrayList);    // 코스요리 오름차순 정렬
        answer = new String[arrayList.size()];  // 배열에 담아준다
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }

    private static List<Node> findCourseByCnt(List<Node> list, int courseCnt) {
        List<Node> resultList = new ArrayList<>();
        int MAX = Integer.MIN_VALUE;    // 가장 많이 함께 주문된 메뉴 구성
        for (Node node : list) {
            if (node.str.length() == courseCnt) {
                MAX = Math.max(MAX, node.cnt);
                resultList.add(node);
            }
        }

        List<Node> returnList = new ArrayList<>();
        for (Node node : resultList) {
            if (node.cnt == MAX) {  // 만약 가장 많이 함께 주문된 메뉴 구성이 여러 개라면, 모두 배열에 담아
                returnList.add(node);
            }
        }
        return returnList;
    }

    private static void combination(int len, int index, char[] chars, boolean[] visit, int start, int n, int r) {
        if (r == 0) {
            String menu = getCombiMenu(chars, visit, n);    // nCr
            if (!map.containsKey(menu)) {   // 해당 조합을 처음 뽑은 경우
                Integer[] arr = new Integer[len];   // arr는 해당 조합에 대해서 각 손님들이 고를 수 있는지 체크
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
