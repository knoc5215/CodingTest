package kakao.test_2018;

import java.util.*;
import java.util.regex.Pattern;

public class p1 {

    static final String pattern = "^[A-Z]+$";

    public static void main(String[] args) {
        String[][] inputs = {{"FRANCE", "french"}, {"handshake", "shake hands"}, {"aa1+aa2", "AAAA12"}, {"E=M*C^2", "e=m*c^2"}};
        for (int i = 0; i < inputs.length; i++) {
            String[] param = inputs[i];
            System.out.println("#" + (i + 1) + " " + solution(param[0], param[1]));
        }
    }

    /*
        자카드 유사도 = 교집합 / 합집합
     */
    public static int solution(String str1, String str2) {
        int answer = 0;

        StringBuffer sb = new StringBuffer();
        ArrayList<String> listFirst = new ArrayList<>();
        ArrayList<String> listSecond = new ArrayList<>();
//        System.out.println("str1 =========================================");
        for (int i = 0; i < str1.length() - 1; i++) {
            String pair = str1.substring(i, i+2).toUpperCase();
            if (!isBlankOrNumberOrSpecial(pair)) {
//                System.out.println("잘못된 글자쌍입니다.... " + pair);
                continue;
            }
//            System.out.println("현재 글자쌍 : " + pair);
//            String key = pair.toUpperCase();

            listFirst.add(pair);

        }
//        System.out.println("str2 =========================================");
        for (int i = 0; i < str2.length() - 1; i++) {

            String pair = str2.substring(i, i+2).toUpperCase();
            if (!isBlankOrNumberOrSpecial(pair)) {
//                System.out.println("잘못된 글자쌍입니다.... " + pair);
                continue;
            }
//            System.out.println("현재 글자쌍 : " + pair);
//            String key = pair.toUpperCase();

            listSecond.add(pair);

        }


        ArrayList<String> union = getUnionList(listFirst, listSecond);
        ArrayList<String> intersection = getIntersectionList(listFirst, listSecond);


        if (intersection.size() == 0) {
            return 65536;
        } else {
            return (int) ((double) intersection.size() / (double) union.size() * (double) 65536);
        }


    }

    static ArrayList<String> getUnionList(ArrayList<String> listFirst, ArrayList<String> listSecond) {
        listFirst = (ArrayList<String>) listFirst.clone();
        listSecond = (ArrayList<String>) listSecond.clone();

        ArrayList<String> union = new ArrayList<>();
        for (String string : listFirst) {
            if (listSecond.contains(string)) {
                listSecond.remove(string);
            }
            union.add(string);
        }
        union.addAll(listSecond);

        return union;
    }

    static ArrayList<String> getIntersectionList(ArrayList<String> listFirst, ArrayList<String> listSecond) {
        listFirst = (ArrayList<String>) listFirst.clone();
        listSecond = (ArrayList<String>) listSecond.clone();

        ArrayList<String> intersection = new ArrayList<>();
        for (String string : listFirst) {
            if (listSecond.contains(string)) {
                intersection.add(string);
                listSecond.remove(string);
            }
        }

        return intersection;
    }

    static boolean isBlankOrNumberOrSpecial(String ch) {
        if (Pattern.matches(pattern, ch)) {
            return true;
        } else {
            return false;
        }

    }
}
