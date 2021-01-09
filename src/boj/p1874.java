package boj;

import java.util.Scanner;
import java.util.Stack;

public class p1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        int index = 1;
        while (index <= n) {
            int next = arr[index];

            if (stack.size() < 1) {
                for (; num <= next; num++) {
                    stack.push(num);
                    sb.append('+');
                }
            } else {
                int top = stack.peek();
                if (next == top) {
                    stack.pop();
                    sb.append('-');
                    index++;
                } else {
                    if (num > next) {
                        System.out.println("NO");
                        return;
                    }
                    for (; num <= next; num++) {
                        stack.push(num);
                        sb.append('+');
                    }
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }


    }
}


