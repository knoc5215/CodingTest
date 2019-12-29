package boj.dijkstra;

import java.util.*;

public class p1753 {
    static int[][] ad;
    static boolean[] visit;
    static int[] dist;
    static int V, E;
    static int start;
    static int MAX_V = 20000;
    static final int INF = 1000000000;
    static List<List<Pair>> P;

    static PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.dist - o2.dist;
        }
    });

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();   // 정점의 개수
        E = sc.nextInt();   // 간선의 개수
        start = sc.nextInt() - 1;

        P = new ArrayList<>();
        for (int i = 0; i < MAX_V; i++) {
            P.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            P.get(x - 1).add(new Pair(y - 1, w));
        }

        dist = new int[MAX_V];
        Arrays.fill(dist, INF);
        visit = new boolean[MAX_V];

        dist[start] = 0;
        pq.add(new Pair(start, 0));
        while (!pq.isEmpty()) {
            int cur;
            do {
                cur = pq.peek().pos;
                pq.poll();
            } while (!pq.isEmpty() && visit[cur]);

            if (visit[cur]) {
                break;
            }

            visit[cur] = true;
            List<Pair> curList = P.get(cur);
            for (Pair p : curList) {
                int next = p.pos;
                int d = p.dist;

                if (dist[next] > dist[cur] + d) {
                    dist[next] = dist[cur] + d;
                    pq.add(new Pair(next, dist[next]));
                }
            }

        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }


    static class Pair {
        int pos, dist;

        public Pair(int pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }
}
