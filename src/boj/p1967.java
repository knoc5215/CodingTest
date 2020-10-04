package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1967 {
    static int n, reverse;
    static ArrayList<Node>[] list;
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, value));
            list[child].add(new Node(parent, value));
        }

        visit = new boolean[n + 1];
        DFS(0, 1);  // 루트는 항상 1 -> 항상 중간 point -> 반지름 계산하기 위한 기준점

        visit = new boolean[n + 1];
        DFS(0, reverse);    // 현재 reverse = 반지름이 가장 긴 노드

        System.out.println(max);


    }

    static void DFS(int sum, int from) {
        if (max < sum) {
            max = sum;
            reverse = from; // 최대값이 갱신된다 -> 반지름이 가장 길다 -> reverse 시작점 갱신
        }


        for (Node fromNode : list[from]) {
            if (!visit[fromNode.next]) {
                visit[fromNode.next] = true;
                DFS(sum + fromNode.value, fromNode.next);
            }
        }
    }


    static class Node {
        int next, value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }
    }

}
