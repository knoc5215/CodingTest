package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    백준 1753번 최단거리 문제
    다익스트라
    인접리스트 (2차원 배열로 풀면 메모리 초과)
 */
public class p1753 {
    static int V, E;
    static int K;
    static List<Node>[] lists;
    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점의 개수
        E = Integer.parseInt(st.nextToken());   // 간선의 개수

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());   // 시작점

        lists = new ArrayList[V + 1];   // 인접리스트 1~V
        for (int i = 1; i < V + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF); // 모든 정점으로 거리 무한대로 초기화


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lists[from].add(new Node(to, cost));

        }


        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 아직 방문하지 않은 정점들 중 거리가 가장 가까운 정점을 하나 선택하기 위한 우선순위 큐
        priorityQueue.add(new Node(K, 0));
        dist[K] = 0;    // 시작점  거리 0으로 초기화

        boolean[] visit = new boolean[V + 1];

        while (!priorityQueue.isEmpty()) {
            Node curNode = priorityQueue.poll();    // 가장 가까운 정점이 나온다
            int cur = curNode.vertex;

            if (visit[cur]) continue;   // 아직 방문하지 않았을때만 진행
            visit[cur] = true;

            for (Node node : lists[cur]) {  // 해당 정점의 인접한 정점들에 대해서
                if (dist[node.vertex] > dist[cur] + node.cost) {    // 더 짧은 경로가 있다면
                    dist[node.vertex] = dist[cur] + node.cost;  // 갱신해주고
                    priorityQueue.add(new Node(node.vertex, dist[node.vertex]));
                }
            }


        }

        for (int i = 1; i < dist.length; i++) {
            int cost = dist[i];
            System.out.println(cost == INF ? "INF" : cost);
        }

    }

    static class Node {
        int vertex, cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }


}
