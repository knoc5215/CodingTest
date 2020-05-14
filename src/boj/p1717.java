package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 집합의 표현 */
public class p1717 {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");

        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);

        arr = new int[n+1];
        Arrays.fill(arr, -1);

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int join = Integer.parseInt(inputs[0]); // 0 : join, 1 : find
            int a = Integer.parseInt(inputs[1]);
            int b = Integer.parseInt(inputs[2]);

            switch (join) {
                case 0:
                    union(a,b);
                    break;
                case 1:
                    int setOfA = find(a);
                    int setOfB = find(b);
                    if(setOfA == setOfB) {
                        System.out.println("YES");
                    }
                    else {
                        System.out.println("NO");
                    }
                    break;
            }

        }
    }

    public static int find(int n) {
        if (arr[n] < 0) {
            return n;
        }

        arr[n] = find(arr[n]);
        return arr[n];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a==b) {
            return;
        }
        arr[b] = a;
    }
}
