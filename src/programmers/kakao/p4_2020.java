package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

/*
   가사에 사용된 모든 단어들이 담긴 배열 words와 찾고자 하는 키워드가 담긴 배열 queries가 주어질 때
   각 키워드 별로 매치된 단어가 몇 개인지 순서대로 배열에 담아 반환하도록 solution 함수를 완성해 주세요.
    */
public class p4_2020 {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};

        int[] answer = solutionWithTrie(words, queries);
        for (int val : answer) {
            System.out.print(val + " ");
        }
    }


    public static int[] solution(String[] words, String[] queries) {

        List<Integer> matchList = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int count = 0;  // match count
            System.out.println("현재 탐색중인 쿼리 : " + query);

            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                System.out.println("\t현재 매치할 단어 : " + word);

                if (query.length() != word.length()) {
                    System.out.println("\t 길이가 다릅니다.");
                    continue;
                }


                boolean match = match(query, word);

                if (match) {
                    System.out.println(query + " match with " + word);
                    count++;
                }

            }
            matchList.add(count);   // 매치카운트 추가
        }

        // list to array
        int[] answer = new int[queries.length];
        for (int i = 0; i < matchList.size(); i++) {
            answer[i] = matchList.get(i);
        }

        return answer;
    }

    static boolean match(String query, String word) {
        boolean isMatch = true;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) != '?') {
                if (query.charAt(i) != word.charAt(i)) {
                    isMatch = false;
                    break;
                }
            }
        }
        return isMatch;
    }

    public static int[] solutionWithTrie(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie[] tries = new Trie[10001];
        Trie[] reverseTries = new Trie[10001];

        for (String word : words) {
            int len = word.length();

            try {
                tries[len].insert(word.toCharArray());
            } catch (Exception e) {
                tries[len] = new Trie();
                tries[len].insert(word.toCharArray());
            }

            word = (new StringBuffer(word)).reverse().toString();
            try {
                reverseTries[len].insert(word.toCharArray());
            } catch (Exception e) {
                reverseTries[len] = new Trie();
                reverseTries[len].insert(word.toCharArray());
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if (query.indexOf('?') == 0) {
                try {
                    query = (new StringBuffer(query)).reverse().toString();
                    answer[i] = reverseTries[query.length()].search(query.toCharArray());
                } catch (Exception e) {
                    continue;
                }
            } else {
                try {
                    answer[i] = tries[query.length()].search(query.toCharArray());
                } catch (Exception e) {
                    continue;
                }
            }
        }

        return answer;
    }


}

class Trie {
    int count;
    Trie[] childList;

    Trie() {
        childList = new Trie[26];
        count = 0;
    }

    void insert(char[] word) {
        Trie current = this;
        for (char ch : word) {
            current.count++;
            if (current.childList[ch - 'a'] != null) {
                current = current.childList[ch - 'a'];
            } else {
                current.childList[ch - 'a'] = new Trie();
                current = current.childList[ch - 'a'];
            }
        }
    }

    int search(char[] query) {
        Trie current = this;
        for (char ch : query) {
            if (ch == '?') {
                return current.count;
            }

            if (current.childList[ch - 'a'] != null) {
                current = current.childList[ch - 'a'];
            } else {
                return 0;
            }
        }

        return current.count;
    }
}






