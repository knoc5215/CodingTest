package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1339 {
    static Map<Character, Integer> map; // 문자 - 값
    static Set<Character> set;  // 알파벳 중복제거
    static List<String> words;  // 단어 리스트
    static List<Character> alphabet;    // 알파벳 중복제거된 리스트
    static boolean[] visit; // 방문체크
    static int n;
    static int max = Integer.MIN_VALUE; // 최대값 계산하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        set = new HashSet<>();
        words = new ArrayList<>();

        visit = new boolean[10];

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.add(word);
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                set.add(ch);    // 알파벳 중복제거
            }
        }
        alphabet = new ArrayList<>(set);
        permutation(0); // 알파벳 순열 만들기
        System.out.println(max);

    }

    static void permutation(int depth) {
        if (depth == alphabet.size()) {     // 모든 알파벳 셋팅이 끝났다면
            int sum = 0;
            for (String word : words) {
                sum += wordSum(word);   // 단어마다 숫자 누적합
            }
            max = Math.max(max, sum);   // 최대값 갱신
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                map.put(alphabet.get(depth), i);    // 알파벳 순열만들면서, 값도 갱신
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }


    static int wordSum(String word) {   // string으로하면 부담스러움
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            sum *= 10;  // 자릿수 고려해서
            sum += map.get(ch);
        }
        return sum;
    }
}
