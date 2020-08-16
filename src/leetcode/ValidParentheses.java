package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    private HashMap<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }

    // leetCode solution
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (this.mappings.containsKey(cur)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != this.mappings.get(cur)) {
                    return false;
                }
            } else {
                stack.push(cur);
            }
        }

        return stack.empty();
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        if (s.length() == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        boolean valid = true;
        for (int i = 0; i < s.length(); i++) {
            char pair = s.charAt(i);

            if (pair == '(' || pair == '{' || pair == '[') {
                stack.push(pair);
            } else {
                if (stack.size() < 1) {
                    valid = false;
                    break;
                }

                char top = stack.peek();
                if (pair == ')') {
                    if (top != '(') {
                        valid = false;
                        break;
                    }
                } else if (pair == '}') {
                    if (top != '{') {
                        valid = false;
                        break;
                    }
                } else {
                    if (top != '[') {
                        valid = false;
                        break;
                    }
                }
                stack.pop();
            }
        }
        if (stack.size() > 0) {
            valid = false;
        }
        return valid;
    }
}
