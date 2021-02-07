package programmers.kakao_previous.blind_2021;

import java.util.*;

/*
 * [조건]을 만족하는 사람 중 코딩테스트 점수를 X점 이상 받은 사람은 모두 몇 명인가?
 */
public class s3_RankSearch {
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
//        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        String[] query = {"- and - and - and - 150"};
        int[] ans = solution(info, query);
        for (int ret : ans) {
            System.out.print(ret + " ");
        }
    }

    static String[] langArr = {"cpp", "java", "python", "-"};
    static String[] endArr = {"backend", "frontend", "-"};
    static String[] careerArr = {"junior", "senior", "-"};
    static String[] soulFoodArr = {"pizza", "chicken", "-"};


    public static int[] solution(String[] info, String[] query) {

        /**
         * 모든 조합을 만든다
         * */
        HashMap<String, HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>>> langMap = new HashMap();
        for (String lang : langArr) {
            langMap.put(lang, new HashMap<>());
        }

        for (String lang : langMap.keySet()) {
            HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> endMap = langMap.get(lang);
            for (String dep : endArr) {
                endMap.put(dep, new HashMap<>());
            }

            for (String end : endMap.keySet()) {
                HashMap<String, HashMap<String, ArrayList<Integer>>> careerMap = endMap.get(end);
                for (String career : careerArr) {
                    careerMap.put(career, new HashMap<>());
                }

                for (String career : careerMap.keySet()) {
                    HashMap<String, ArrayList<Integer>> soulFoodMap = careerMap.get(career);
                    for (String soulFood : soulFoodArr) {
                        soulFoodMap.put(soulFood, new ArrayList<Integer>());
                    }
                }
            }
        }
        /**
         * 입력을 바탕으로 map에 score를 추가해준다
         * */
        for (String infoString : info) {
            String[] parse = infoString.split(" ");
            String lang = parse[0];
            String end = parse[1];
            String career = parse[2];
            String soulFood = parse[3];
            int score = Integer.parseInt(parse[4]);
            langMap.get(lang).get(end).get(career).get(soulFood).add(score);
        }

        /**
         * 입력받은 값에 대해서 정렬을 해준다
         * */
        for (HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> endMap : langMap.values()) {
            for (HashMap<String, HashMap<String, ArrayList<Integer>>> careerMap : endMap.values()) {
                for (HashMap<String, ArrayList<Integer>> soulFoodMap : careerMap.values()) {
                    for (ArrayList<Integer> scoreList : soulFoodMap.values()) {
                        scoreList.sort(null);
                    }
                }
            }
        }

        int[] answer = new int[query.length];
        int i = 0;
        // 쿼리마다 돌면서
        for (String sql : query) {
            String[] parse = sql.split(" and ");
            String[] subParse = parse[3].split(" ");    // soulFood score

            String lang = parse[0]; // java
            String end = parse[1];  // backend
            String career = parse[2];   // junior
            String soulFood = subParse[0];  // pizza
            int minScore = Integer.parseInt(subParse[1]);   // 100

            for (String langString : langArr) {
                if (lang.equals("-") || lang.equals(langString)) {
                    HashMap<String, HashMap<String, HashMap<String, ArrayList<Integer>>>> endMap = langMap.get(langString);

                    for (String endString : endArr) {
                        if (end.equals("-") || end.equals(endString)) {
                            HashMap<String, HashMap<String, ArrayList<Integer>>> careerMap = endMap.get(endString);

                            for (String careerString : careerArr) {
                                if (career.equals("-") || career.equals(careerString)) {
                                    HashMap<String, ArrayList<Integer>> soulFoodMap = careerMap.get(careerString);

                                    for (String soulFoodString : soulFoodArr) {
                                        if (soulFood.equals("-") || soulFood.equals(soulFoodString)) {
                                            /**
                                             * 이분탐색으로 minScore보다 큰 값들의 개수를 찾는다
                                             * for문으로 탐색하면, 시간초과 발생
                                             * */
                                            ArrayList<Integer> scores = soulFoodMap.get(soulFoodString);

                                            int n = scores.size();
                                            int min = 0;
                                            int max = n - 1;
                                            int mid = max;
                                            int idx = n;

                                            while (min <= max) {
                                                mid = (min + max) / 2;
                                                if (scores.get(mid) >= minScore) {
                                                    idx = mid;
                                                    max = mid - 1;
                                                } else {
                                                    min = mid + 1;
                                                }
                                            }
                                            answer[i] += n - idx;
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
            }
            i++;
        }
        return answer;
    }
}
