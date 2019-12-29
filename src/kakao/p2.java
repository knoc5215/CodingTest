package kakao;

import java.util.*;

public class p2 {

    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] ret = solution(s);
        for (int val : ret) {
            System.out.println(val + " ");
        }
    }

    public static int[] solution(String s) {

        Set<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length() - 1; i++) {
            sb.append(s.charAt(i));
        }

        System.out.println(sb);

        List<String> arr = new ArrayList<>();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '{') {
                String cut = findClosePair(sb, i);
                System.out.println("cur > " + cut);
                arr.add(cut);

               /* String[] arr = cut.split(",");
                for (int j = 0; j < arr.length; j++) {
                    int val = Integer.parseInt(arr[j]);
                    if(!set.contains(val)) {
                        set.add(val);
                    }
                }*/
            }
        }

        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.size(); i++) {
            String cur = arr.get(i);
            System.out.println("현재 " + cur);
            String[] split = cur.split(",");
            for (int j = 0; j < split.length; j++) {
                int val = Integer.parseInt(split[j]);
                if (!queue.contains(val)) {
                    queue.add(val);
                }
            }
        }

        int[] answer = new int[queue.size()];
        int idx = 0;
        while (!queue.isEmpty()) {
            answer[idx++] = queue.poll();
        }

//        Iterator<Integer> itr = set.iterator();
//        int idx = 0;
//        while (itr.hasNext()) {
//            int val = itr.next();
//            answer[idx++] = val;
//        }


        return answer;
    }

    public static String findClosePair(StringBuilder sb, int start) {
        StringBuilder returnStr = new StringBuilder();
        for (int i = start + 1; i < sb.length(); i++) {

            if (sb.charAt(i) == '}') {
                break;
            }

            returnStr.append(sb.charAt(i));
        }


        return returnStr.toString();
    }
}
