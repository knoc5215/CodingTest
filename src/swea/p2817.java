package swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    A1, A2, ... , AN의 N개의 자연수가 주어졌을 때
    최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 */
public class p2817 {
    static int[] arr;
    static int N, K;
    static int cnt;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();
            cnt = 0;

            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < N; i++) {
//                System.out.println("============================= " + i + "번 시작===================");
                visit = new boolean[N];
                DFS(i, 0);
            }


            System.out.println("#" + test_case + " " + cnt);
        }
    }

    static void DFS(int cur, int sum) {
        visit[cur] = true;
        sum += arr[cur];

        if (sum == K) {
            cnt++;
        }
        for (int i = cur; i < arr.length; i++) {
            if (!visit[i]) {
                DFS(i, sum);
                visit[i] = false;
            }
        }
    }
}