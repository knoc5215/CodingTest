package programmers.kakao_previous.winterIntern_2019;

import java.util.*;

public class Tuple {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        list.add("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        list.add("{{20,111},{111}}");
        list.add("{{123}}");
        list.add("{{4,2,3},{3},{2,3,4,1},{2,3}}");

        for (String s : list) {
            int[] ans = solution(s);
            for (int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    public static int[] solution(String s) {
        int[] answer = {};

        String str = s.substring(1, s.length() - 1);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ',') {
                if (i - 1 >= 0 && chars[i - 1] == '}' && i + 1 < chars.length && chars[i + 1] == '{') {
                    chars[i] = ' ';
                }
            }
        }

        s = new String(chars);
        StringTokenizer st = new StringTokenizer(s);
        List<String> tuples = new ArrayList<>();

        while (st.hasMoreTokens()) {
            tuples.add(st.nextToken());
        }

        List<Integer>[] list = new ArrayList[tuples.size()];
        for (int i = 0; i < tuples.size(); i++) {
            list[i] = new ArrayList<>();
            String val = tuples.get(i);
            val = val.replaceAll("\\{", "");
            val = val.replaceAll("\\}", "");
            val = val.replaceAll(",", " ");
            st = new StringTokenizer(val);
            while (st.hasMoreTokens()) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < list.length; i++) {
            List<Integer> inner = list[i];
            for(int val :inner) {
                System.out.print(val + " ");
            }
            System.out.println();
        }





        return answer;
    }

    static boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
