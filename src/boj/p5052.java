package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
전화번호 목록이 일관성을 유지하려면, 한 번호가 다른 번호의 접두어인 경우가 없어야 한다.
 */
public class p5052 {
    static int n;
    static List<String> list;
    static Trie root;
    public static final int NUMBERS = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            root = new Trie();
            list = new ArrayList<>();

            n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                String word = br.readLine();
                list.add(word);
                insert(word);
            }

            boolean check = true;
            for (String number : list) {
                if (!find(number)) {
                    check = false;
                    break;
                }
            }
            if (check)
                sb.append("YES\n");
            else
                sb.append("NO\n");

        }

        System.out.println(sb.toString());
    }

    static void insert(String word) {
        Trie curTrie = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - '0';
            if (curTrie.children[idx] == null) {
                curTrie.children[idx] = new Trie();
            }
            curTrie = curTrie.children[idx];
        }
        curTrie.isEndWord = true;
    }

    static boolean find(String word) {
        Trie curTrie = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - '0';
            if (curTrie.isEndWord)
                return false;
            curTrie = curTrie.children[idx];
        }

        return true;
    }


    static class Trie {
        boolean isEndWord;
        Trie[] children;

        public Trie() {
            isEndWord = false;
            children = new Trie[NUMBERS];
            Arrays.fill(children, null);
        }
    }
}






