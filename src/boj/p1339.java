package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1339 {
    static Map<Character, Integer> map;
    static Set<Character> set;
    static List<String> words;
    static List<Character> alphabet;
    static boolean[] visit;
    static int n;
    static int max = Integer.MIN_VALUE;

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
                set.add(ch);
            }
        }
        alphabet = new ArrayList<>(set);
        permutation(0);
        System.out.println(max);

    }

    static void permutation(int depth) {
        if (depth == alphabet.size()) {
            int sum = 0;
            for (String word : words) {
                sum += wordSum(word);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visit[i]) {
                visit[i] = true;
                map.put(alphabet.get(depth), i);
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }


    static int wordSum(String word) {
        int sum = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            sum *= 10;
            sum += map.get(ch);
        }
        return sum;
    }
}
