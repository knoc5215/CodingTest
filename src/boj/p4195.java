package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 친구 네트워크 */
/*
    두 사람의 친구 네트워크에 몇 명이 있는지 구하는 프로그램을 작성하시오.
 */
public class p4195 {
    static int T;
    static int F;
    static int[] p, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            F = Integer.parseInt(br.readLine());
            p = new int[200001];
            r = new int[200001];
            for (int j = 1; j <= 200000; j++) {
                p[j] = j;
                r[j] = 1;
            }

            int index = 1;
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < F; j++) {
                String[] friends = br.readLine().split(" ");
                for (String name : friends) {
                    if (!map.containsKey(name)) {
                        map.put(name, index++);
                    }
                }

                int a = map.get(friends[0]);
                int b = map.get(friends[1]);

                System.out.println(union(a, b));
            }


        }

    }


    public static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        p[a] = find(p[a]);
        return p[a];
    }

    public static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            p[a] = b;
            r[b] += r[a];
        }

        return r[b];


    }
}
