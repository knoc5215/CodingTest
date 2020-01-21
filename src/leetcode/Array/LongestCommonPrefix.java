package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length < 1) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }

        Set<Character> set;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < min) {
            set = new HashSet<>();

            System.out.println("current idx is " + idx);
            for (int i = 0; i < strs.length; i++) {
                set.add(strs[i].charAt(idx));
            }

            if (set.size() == 1) {
                Object[] chars = set.toArray();
                sb.append(chars[0]);
                System.out.println("\tappend " + chars[0]);

                idx++;
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
