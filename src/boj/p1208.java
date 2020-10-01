package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
부분수열의 합2
항상 int, long 범위에 주의하자
map으로 푸는 방식도 있음(boj 제출기록 참고하기)
 */
public class p1208 {
    static int N, S;
    static int[] arr;

    static List<Integer> listOfLeft = new ArrayList<>();
    static List<Integer> listOfRight = new ArrayList<>();
    static long ret = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSum(0, 0, N / 2, listOfLeft);
        makeSum(0, N / 2, N, listOfRight);

        Collections.sort(listOfLeft);
        Collections.sort(listOfRight);

        int left = 0;
        int right = listOfRight.size() - 1;

        while (left < listOfLeft.size() && right >= 0) {
            int a = listOfLeft.get(left);
            int b = listOfRight.get(right);

            if (a + b == S) {
                long cnt_a = 0; // 범위 주의
                while (left < listOfLeft.size() && listOfLeft.get(left) == a) {
                    cnt_a++;
                    left++;
                }

                long cnt_b = 0; // 범위 주의
                while (right >= 0 && listOfRight.get(right) == b) {
                    cnt_b++;
                    right--;
                }

                ret += cnt_a * cnt_b;
            }

            if (a + b < S) {
                left++;
            }
            if (a + b > S) {
                right--;
            }
        }

        if (S == 0) ret--;  // 합계가 0인 것은 초기값이 0일때 한번 카운팅되므로, 한번 빼줘야함

        System.out.println(ret);


    }

    static void makeSum(int sum, int idx, int end, List<Integer> list) {
        if (idx >= end) {
            list.add(sum);
            return;
        }
        makeSum(sum, idx + 1, end, list);
        makeSum(sum + arr[idx], idx + 1, end, list);
    }

}
