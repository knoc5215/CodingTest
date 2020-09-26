package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p2805 {
    static long N, M;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        long left = 0;  // 나무의 최소 높이
        long right = 1000000000;    // 나무의 최대 높이
        while (st.hasMoreTokens()) {
            long H = Long.parseLong(st.nextToken());
            right = Math.max(right, H); // 나무의 최대 높이 갱신
            list.add(H);
        }

        long maxHeight = -1;

        // 이분탐색
        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = cut(mid);    // 절단기로 자른 나무 토막들의 합
            if (sum < M) {  // 취할 수 없다면
                right = mid - 1;
            } else {    // M만큼 취할 수 있다면
                maxHeight = Math.max(maxHeight, mid);   // 절단기의 최대높이 갱신
                left = mid + 1;
            }


        }

        System.out.println(maxHeight);

    }

    static long cut(long H) {
        long sum = 0;
        for (long tree : list) {
            if (tree > H) { // 나무의 높이 > 절단기의 높이 이면 잘라서 취한다
                sum += (tree - H);
            }

        }
        return sum;
    }
}
