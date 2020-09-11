package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
 */
public class p2023 {
    public static int N;
    public static boolean[] visit;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        DFS(0, "");
        for (int val : list) {
            System.out.println(val);
        }
    }

    public static void DFS(int idx, String str) {
        if (idx == N) {
            list.add(Integer.parseInt(str));
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrimeNum(Integer.parseInt(str + i))) {
                DFS(idx + 1, str + i);
            }
        }


    }

    static boolean isPrimeNum(int num) {
        if (num == 1) return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
