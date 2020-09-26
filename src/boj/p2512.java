package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2512 {
    static int N;
    static long M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> reqList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputSum = 0;
        int inputMin = Integer.MAX_VALUE;
        int inputMax = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int input = Integer.parseInt(st.nextToken());
            inputMin = Math.min(inputMin, input);   // 요청 최소값
            inputMax = Math.max(inputMax, input);   // 요청 최대값
            inputSum += input;  // 요청 합

            reqList.add(input);
        }

        M = Long.parseLong(br.readLine());

        if (inputSum <= M) {    // 모든 요청에 대해 지급할 수 있다면
            System.out.println(inputMax);   // 요청 최대값 출력하고
            return; // 그대로 종료
        }

        // 모든 요청에 대해 지급할 수 없다면
        long left = 0;
        long right = 1000000000;    // 요청 금액 상한
        for (int req : reqList) {
            right = Math.max(right, req);   // 금액 상한 가지치기
        }

        // 이분탐색 시작
        long max = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            int sum = 0;
            for (int request : reqList) {
                if (request >= mid) {    // 상한액을 초과하면
                    sum += mid; // 상한액을 지급
                } else {    // 상한액을 초과하지 않으면
                    sum += request; // 요청액 전부를 지급
                }
            }

            if (sum <= M) { // 요청합이 예산 이하라면
                max = Math.max(max, mid);   // 상한액 최대값 갱신
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(max);
    }
}
