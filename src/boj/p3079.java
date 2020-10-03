package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p3079 {
    static int n, m;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 심사관 수
        m = Integer.parseInt(st.nextToken()); // 학생 수

        times = new int[n];  // 심사관 소요시간 배열
        long maxTime = -1;
        for (int i = 0; i < n; i++) {
            int use = Integer.parseInt(br.readLine());
            times[i] = use;
            maxTime = Math.max(maxTime, use);
        }


        long left = 0;
        long right = m * maxTime;  // 가장 오래걸리는 심사관이 * m 명 모두를 처리하는게 최대 시간
        long min = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;

            long avg = 0;   // 평균 완료 가능 인원
            for (long usedTime : times) {
                avg += (mid / usedTime);    // mid 초 내에 해당 심사대에서 심사받을 수 있는 인원 수
                if (avg >= m)
                    break;

            }

            // avg 누적합 = 총 처리가능인원

            if (avg >= m) { // 모든 학생 수 이상을 처리할 수 있다면
                min = Math.min(min, mid);
                right = mid - 1;    // 아래쪽으로 이분
            } else {
                left = mid + 1; // 위쪽으로 이분
            }
        }

        System.out.println(min);


    }


}
