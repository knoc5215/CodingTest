package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class p10828 {
    public static List<Integer> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = stoi(br.readLine());
        StringTokenizer st;
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            if ("push".equals(method)) {
                int value = stoi(st.nextToken());
                push(value);
            } else {
                switch (method) {
                    case "pop":
                        System.out.println(pop());
                        break;
                    case "top":
                        System.out.println(top());
                        break;
                    case "size":
                        System.out.println(size());
                        break;
                    case "empty":
                        empty();
                        break;
                }
            }


        }
    }

    public static void push(int value) {
        stack.add(value);
    }

    public static int pop() {
        if (stack.size() > 0) {
            return stack.remove(stack.size() - 1);
        } else {
            return -1;
        }
    }

    public static int top() {
        if (stack.size() > 0) {
            return stack.get(stack.size() - 1);
        } else {
            return -1;
        }
    }

    public static int size() {
        return stack.size();
    }

    public static void empty() {
        System.out.println(stack.size() > 0 ? 0 : 1);
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
