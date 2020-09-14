package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1238 {
    static int N, M, X;
    static List<Node>[] go, back;   // 단방향이라 가는거 오는거 2개로
    static int[] distSum;
    static boolean[] visit;
    static PriorityQueue<Node> priorityQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 학생수(마을수)
        M = Integer.parseInt(st.nextToken());   // 도로수
        X = Integer.parseInt(st.nextToken());   // 목적지

        go = new ArrayList[N + 1];
        back = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            go[i] = new ArrayList<Node>();
            back[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            go[from].add(new Node(to, cost));
            back[to].add(new Node(from, cost));
        }

        distSum = new int[N + 1];   // 각 학생마다 왕복거리 저장

        for (int i = 1; i < N + 1; i++) {
            dijkstra(i);    // 갔다가
            dijkstra_back(i);   // 돌아온다
        }

        Arrays.sort(distSum);
        int min = distSum[N];

        System.out.println(min);


    }

    static void dijkstra(int start) {

        priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[N + 1];

        priorityQueue.add(new Node(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            int from = cur.vertex;

            if (visit[from]) continue;
            visit[from] = true;
            for (Node nextNode : go[from]) {
                int to = nextNode.vertex;
                if (dist[to] > dist[from] + nextNode.cost) {
                    dist[to] = dist[from] + nextNode.cost;
                    priorityQueue.add(new Node(to, dist[to]));
                }
            }
        }

        distSum[start] += dist[X];
        // start는 탐색중인 학생번호
        // distSum[start] = start학생의 X까지의 최단거리


    }

    // 이번엔 돌아가는 최단거리 계산(단방향이라 갈때 올때 길이 다르다)
    static void dijkstra_back(int start) {

        priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visit = new boolean[N + 1];

        priorityQueue.add(new Node(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node cur = priorityQueue.poll();
            int from = cur.vertex;

            if (visit[from]) continue;
            visit[from] = true;
            for (Node nextNode : back[from]) {
                int to = nextNode.vertex;
                if (dist[to] > dist[from] + nextNode.cost) {
                    dist[to] = dist[from] + nextNode.cost;
                    priorityQueue.add(new Node(to, dist[to]));
                }
            }
        }

        distSum[start] += dist[X];
        // start는 탐색중인 학생번호
        // distSum[start] = start학생의 X까지의 최단거리
        // 왕복이니 한번 더 더해준다

    }


    static class Node {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
