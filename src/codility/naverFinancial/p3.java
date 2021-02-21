package codility.naverFinancial;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class p3 {
    // 크기는 1<=N<=100000
    // 수의 범위는 1000000000 +-
    public static void main(String[] args) {
        int[] A = {3, 2, -2, 5, -3};
        System.out.println(solution(A));

    }

    public static int solution(int[] A) {
        int max = 0;
        Map<Integer, Integer> plusMap = new HashMap<>();
        Map<Integer, Integer> minusMap = new HashMap<>();
        for (int num : A) {
            if (num > 0) {
                if (!plusMap.containsKey(num)) {
                    plusMap.put(num, 1);
                } else {
                    plusMap.put(num, plusMap.get(num) + 1);
                }
            } else {
                if (!minusMap.containsKey(num)) {
                    minusMap.put(num, 1);
                } else {
                    minusMap.put(num, minusMap.get(num) + 1);
                }
            }
        }

        Set<Integer> plusKeys = plusMap.keySet();
        Set<Integer> minusKeys = minusMap.keySet();

        for (int plusKey : plusKeys) {
            if (minusKeys.contains(-plusKey)) {
                max = Math.max(max, plusKey);
            }
        }

        return max;
    }


}
