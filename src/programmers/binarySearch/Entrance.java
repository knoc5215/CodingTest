package programmers.binarySearch;

import java.util.Arrays;

/*
입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */
public class Entrance {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long answer = solution(n, times);
        System.out.println(answer);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long left = 1;
        long right = times[times.length - 1] * n;
        long mid = 0;
        answer = Long.MAX_VALUE;

        while (left <= right) {
            mid = (left + right) / 2;
            if (isPassed(times, n, mid)) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    static boolean isPassed(int[] times, int n, long mid) {
        long amount = 0;
        for (int i = 0; i < times.length; i++) {
            amount += mid / times[i];
        }

        return amount >= n;
    }
}
