package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p1038 {
    static int n;
    static List<Long> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        if (n > 1022) { // 9876543210이 마지막 감소하는 수이며 1022번째이다
            System.out.println(-1); // 존재하지 않음
            return;
        }

        for (long i = 1; i <= 9; i++) { // 1~9 한자리 수로 시작
            solution(i, 1);
        }

        Collections.sort(list);
        System.out.println(list.get(n - 1));
    }

    static void solution(long number, int idx) {
        if (idx > 10) return;

        list.add(number);
        for (int i = 0; i < 10; i++) {
            if (i < number % 10) {  // i보다 number의 끝자리 수가 더 크다면 ( 1 < 54에서 끝자리 4)
                solution((number * 10) + i, idx + 1);   // 54 * 10 + 1 = 541, idx+1
            }
        }

    }


}
