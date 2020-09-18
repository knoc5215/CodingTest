package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.
타임머신
벨만-포드 알고리즘
다익스트라와 다르게, 가중치 음수값 존재할때 사용하자
 */
public class p11657 {
    static int N, M;
    static int[][] map;
    static long[] dist; // 음수 사이클 범위 초과 (비용 절대값 10,000)
    public static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        dist = new long[N];

        ArrayList<Node>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            map[from][to] = cost;

            Node node = new Node(to, cost);
            adj[from].add(node);
        }

        for (int i = 0; i < N; i++) {
            dist[i] = INF;
        }

        dist[0] = 0;

        boolean minusCycle = false;
        /*
        루프를 원래는 N-1번을 돌리는데 N번을 돌린다
        음수 사이클 체크하기 위함
        N-1번 루프 ? 최단경로를 구성하는 간선의 수 E = V - 1 인데 ?
        기존대로 V-1개의 간선 루프들 돌리고, 한번 더 돌렸을때 dist값이 갱신된다 ? -> 음수사이클이 있다는 의미이기 때문임.
         */
        for (int i = 0; i < N; i++) {   // 그 이후에 루프를 돌면 최단거리가 갱신되는 일이 발생.
            for (int j = 0; j < N; j++) {
                for (Node node : adj[j]) {
                    int to = node.adj;
                    int cost = node.cost;
                    if (dist[j] != INF && dist[to] > dist[j] + cost) {
                        dist[to] = dist[j] + cost;
                        if (i == N - 1) {   // N번째 루프에서 갱신로직을 탄다 ? 음수 싸이클이 존재한다
                            minusCycle = true;
                        }
                    }
                }
            }
        }

        if (minusCycle) {
            System.out.println(-1);
        } else {
            for (int i = 1; i < N; i++) {
                long cost = dist[i];
                System.out.println(cost == INF ? -1 : cost);
            }
        }


    }

    static class Node {
        int adj, cost;

        public Node(int adj, int cost) {
            this.adj = adj;
            this.cost = cost;
        }
    }
}
