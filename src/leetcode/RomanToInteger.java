package leetcode;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        int ans = 0;

        int i = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);

            if (cur == 'I') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'V') {
                    ans += 4;
                    i += 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'X') {
                    ans += 9;
                    i += 2;
                } else {
                    ans += 1;
                    i += 1;
                }
            } else if (cur == 'X') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'L') {
                    ans += 40;
                    i += 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'C') {
                    ans += 90;
                    i += 2;
                } else {
                    ans += 10;
                    i += 1;
                }
            } else if (cur == 'C') {
                if (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    ans += 400;
                    i += 2;
                } else if (i + 1 < s.length() && s.charAt(i + 1) == 'M') {
                    ans += 900;
                    i += 2;
                } else {
                    ans += 100;
                    i += 1;
                }
            } else {
                if (cur == 'V') {
                    ans += 5;
                } else if (cur == 'L') {
                    ans += 50;
                } else if (cur == 'D') {
                    ans += 500;
                } else {
                    ans += 1000;
                }
                i += 1;

            }
        }
        return ans;
    }
}
