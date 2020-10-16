package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11779 {
    static int n, m;
    static ArrayList<Node>[] list;
    static int[] dist;
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<Node>();
        }
        parent = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        m = stoi(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = stoi(st.nextToken());
            int to = stoi(st.nextToken());
            int cost = stoi(st.nextToken());

            list[from].add(new Node(to, cost));
//            adj[to].add(new Edge(from, cost));
        }


        st = new StringTokenizer(br.readLine());
        int start = stoi(st.nextToken());
        int end = stoi(st.nextToken());

        dijkstra(start, end);


        Stack<Integer> stack = new Stack<>();
        int cur = end;
        while ( cur != start) {
            stack.push(cur);
            cur = parent[cur];
        }
        stack.push(cur);

        System.out.println(dist[end]);
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }




    }

    static void dijkstra(int start, int end) {
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        visit = new boolean[n + 1];


        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        priorityQueue.add(new Node(start, 0));
        while (!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.poll();
            int cur = curNode.v;

            if (visit[cur]) {
                continue;
            }

            visit[cur] = true;

            for (Node node : list[cur]) {
                if (dist[node.v] >= dist[cur] + node.w) {
                    dist[node.v] = dist[cur] + node.w;
                    priorityQueue.add(new Node(node.v, dist[node.v]));
                    parent[node.v] = cur;
                }
            }
        }
    }


    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
