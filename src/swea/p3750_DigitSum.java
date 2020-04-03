package swea;

import java.util.Scanner;

/*
자연수 n에 대해 함수 f(n)은 n의 각 자릿수를 더한 값이다.
예를 들어 n = 588432라면, f(n) = 5 + 8 + 8 + 4 + 3 + 2 = 30인 것이다.
어떤 자연수 n이 주어질 때, n이 한 자리수가 될 때까지 n에 f(n)을 대입하는 것을 반복하면, 최종적으로 n이 어떤 값이 되는지 구하는 프로그램을 작성하라.
예를 들어 n = 588432라면 f(n) = 30이므로 n = 30이 되고, 이 때 f(n) = 3으로 최종적으로 n = 3이 되는 것이다.

각 테스트 케이스의 첫 번째 줄에는 자연수 n(1 ≤ n ≤ 10^18)이 주어진다.
 */
public class p3750_DigitSum {
    static long N;  // input range 1<=input<=10^18

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextLong();
            int ret = (N >= 10) ? getSum(N) : (int) N;  // if N is under 10, return

            System.out.println("#" + test_case + " " + ret);
        }
    }

    static int getSum(long n) {
        long startNum = n;
        int digitSum = 0;

        while (startNum >= 10) {
            digitSum = sumOfRadix(startNum);
            startNum = digitSum;
        }

        return digitSum;
    }

    static int sumOfRadix(long n) {
        int sum = 0;
        String[] digit = String.valueOf(n).split("");

        for (String num : digit) {
            sum += Integer.parseInt(num);;
        }
        return sum;
    }
}
