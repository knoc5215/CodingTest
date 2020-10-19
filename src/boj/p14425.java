package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p14425 {
    static final int ALPHABET = 26;
    static int N, M;
    static Trie root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new Trie();

        while (N-- > 0) {
            insert(br.readLine());
        }

        int count = 0;
        while (M-- > 0) {
            if (find(br.readLine())) count++;
        }
        System.out.println(count);
    }

    static void insert(String word) {
        Trie current = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a'; // ASCII
            if (current.children[idx] == null) {
                current.children[idx] = new Trie();
            }
            current = current.children[idx];    // from root to inside
        }
        current.isLastChar = true;  // check last char
    }

    static boolean find(String word) {
        Trie current = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null) {    // word보다 짧은 단어 -> 그래서 다음이 존재하지 않는다 -> 없다
                return false;
            }
            current = current.children[idx];
        }
        return current.isLastChar;  // 이게 마지막 글라면 찾고자 하는 단어이다
    }

    static class Trie {
        boolean isLastChar;
        Trie[] children;

        public Trie() {
            isLastChar = false;
            children = new Trie[ALPHABET];
            Arrays.fill(children, null);
        }
    }
}
