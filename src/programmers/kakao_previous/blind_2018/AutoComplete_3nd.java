package programmers.kakao_previous.blind_2018;

import java.util.ArrayList;
import java.util.HashMap;

public class AutoComplete_3nd {
    public static void main(String[] args) {
        String[] words = {"go", "gone", "guild"};
        int ans = solution(words);
        System.out.println(ans);
    }

    public static int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                answer++;
                String str = word.substring(0, i);
                if (trie.findLeafs(str).size() == 1) {
                    break;
                }
            }
        }
        return answer;
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        public void insert(String word) {
            TrieNode curNode = root;
            for (char ch : word.toCharArray()) {
                if (curNode.getChild(ch) != null) {
                    curNode = curNode.getChild(ch);
                } else {
                    curNode = curNode.putChild(ch);
                }
            }

            curNode.setLeaf(true);
        }

        public ArrayList<TrieNode> findLeafs(String word) {
            ArrayList<TrieNode> leafList = new ArrayList<>();
            TrieNode curNode = root;

            for (char ch : word.toCharArray()) {
                if (curNode.getChild(ch) != null) {
                    curNode = curNode.getChild(ch);
                } else {
                    leafList.clear();
                    return leafList;
                }
            }

            if (curNode.isLeaf()) {
                leafList.add(curNode);
            }

            leafList.addAll(curNode.getAllLeaf());

            return leafList;
        }
    }

    static class TrieNode {
        private char data;
        private boolean isLeaf;
        private HashMap<Character, TrieNode> children;

        public TrieNode(char data) {
            this.data = data;
            children = new HashMap<Character, TrieNode>();
            isLeaf = false;
        }

        public boolean isLeaf() {
            return isLeaf;
        }

        public void setLeaf(boolean leaf) {
            isLeaf = leaf;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public TrieNode putChild(char ch) {
            TrieNode tempNode = new TrieNode(ch);
            getChildren().put(ch, tempNode);
            return tempNode;
        }

        public TrieNode getChild(char ch) {
            return getChildren().get(ch);
        }

        public ArrayList<TrieNode> getAllLeaf() {
            ArrayList<TrieNode> leafList = new ArrayList<>();
            for (TrieNode child : getChildren().values()) {
                if (child.isLeaf()) {
                    leafList.add(child);
                }
                leafList.addAll(child.getAllLeaf());
            }
            return leafList;
        }
    }
}



