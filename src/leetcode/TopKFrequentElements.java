package leetcode;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] ans = topKFrequent(nums, k);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else {
                map.put(cur, map.get(cur) + 1);
            }
        }

        List<Node> nodeList = new ArrayList<>();

        Set<Integer> keySet = map.keySet();
        Iterator<Integer> itr = keySet.iterator();
        while (itr.hasNext()) {
            int key = itr.next();
            int cnt = map.get(key);

            nodeList.add(new Node(key, cnt));

        }

        nodeList.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.cnt - o1.cnt;
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Node cur = nodeList.get(i);
            ans[i] = cur.val;
        }

        return ans;
    }

    static class Node {
        int val;
        int cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
}
