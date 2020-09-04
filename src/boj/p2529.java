package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p2529 {
    static int N;
    static boolean[] visit; //0~9 숫자 체크
    static String input;    // 부등호 input
    static long max = Long.MIN_VALUE;   // 9,876,543,210 같은 경우에 int 범위 초과하기때문에 long
    static long min = Long.MAX_VALUE;    // 9,876,543,210 같은 경우에 int 범위 초과하기때문에 long
    static String maxStr, minStr;   // print answer

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        input = br.readLine();
        input = input.replaceAll("\\s", "");

        for (int i = 0; i <= 9; i++) {
            visit = new boolean[10];    // 0~9까지 숫자 체크
            visit[i] = true;
            run(1, String.valueOf(i));
        }

        if (maxStr.length() < N + 1) {  // 0이 제일 처음에 온다면
            maxStr = "0" + maxStr;  // 자릿수 맞춰준다
        }
        if (minStr.length() < N + 1) {
            minStr = "0" + minStr;
        }


        System.out.println(maxStr);
        System.out.println(minStr);
    }

    static void run(int depth, String str) {
        if (depth == N + 1) {
            String makeFullString = makeFullString(str, input);

            boolean isPossible = isPossible(makeFullString);
            if (isPossible) {
                min = Math.min(min, Long.parseLong(str));
                minStr = String.valueOf(min);
                max = Math.max(max, Long.parseLong(str));
                maxStr = String.valueOf(max);
            }

        } else {
            for (int i = 0; i <= 9; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    run(depth + 1, str + i);
                    visit[i] = false;
                }
            }

        }


    }

    static String makeFullString(String permutation, String input) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(permutation.charAt(i++));
            if (i == permutation.length()) break;
            sb.append(input.charAt(j++));
        }

        return sb.toString();
    }

    static boolean isPossible(String str) {
        for (int i = 1; i < str.length() - 1; i++) {

            int a = str.charAt(i - 1) - '0';
            int b = str.charAt(i + 1) - '0';

            if (str.charAt(i) == '<') {
                if (a >= b) {
                    return false;
                }
            } else if (str.charAt(i) == '>') {
                if (a <= b) {
                    return false;
                }
            }
        }

        return true;
    }
}
