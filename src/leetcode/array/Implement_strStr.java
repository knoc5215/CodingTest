package leetcode.array;

public class Implement_strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println("ret : " + strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == "") {
            return 0;
        } else {
            int idx = haystack.indexOf(needle);

            return idx;
        }
    }
}
