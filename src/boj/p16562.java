package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    16562 친구비
    가장 적은 비용으로 모든 사람과 친구가 되는 방법을 구하라.
 */
public class p16562 {
    static int N, M, K;
    static int[] money;
    static int[] parent;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);    // 학생 수
        M = Integer.parseInt(inputs[1]);    // 친구관계 수
        K = Integer.parseInt(inputs[2]);    // 보유한 돈

        money = new int[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(input[i]);
        }

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < M; i++) {
            String[] pair = br.readLine().split(" ");
            int a = Integer.parseInt(pair[0]) - 1;
            int b = Integer.parseInt(pair[1]) - 1;
            union(a, b);
        }

        long allSum = 0;
        for (int i = 0; i < N; i++) {
            if (parent[i] == -1) {  // 루트가 -1인 친구한테 비용을 지불하면 다 연결되있으니까 가능
                allSum += money[i];
            }
        }

        if (allSum > K) {   // 초과하면
            System.out.println("Oh no");
        } else {    // 비용에 맞으면
            System.out.println(allSum);
        }
    }


    public static int find(int a) {
        if (parent[a] < 0) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (money[a] > money[b]) {  // 비용이 더 적은 친구를 부모로 한다.
                parent[a] = b;
            } else {
                parent[b] = a;
            }

            return false;
        }

        return true;

    }
}
