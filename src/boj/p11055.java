package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11055 {
    static int[] sum;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        sum = new int[n];
        sum[0] = arr[0];

        for (int cur = 1; cur < n; cur++) {
            sum[cur] = arr[cur];
            for (int before = 0; before < cur; before++) {
                if (arr[before] < arr[cur] && sum[cur] < sum[before] + arr[cur]) {  // sum[cur] < sum[before] + arr[cur] --> 더 크게 증가하는 부분 수열이라면
                                                                                    // 10 90 20 80 100 입력의 경우를 살펴보자
                    sum[cur] = sum[before] + arr[cur];
                }
            }
        }

        int max = 0;
        for (int i : sum) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }

}
