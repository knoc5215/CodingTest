package boj.dijkstra;

import java.util.*;

public class p1916 {
    static final int MAX_V = 1000;
    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.dist - o2.dist;
        }
    });

    static int[] dist;
    static List<List<Pair>> list;
    static int N, M;
    static boolean[] visit;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 도시의 개수
        M = sc.nextInt();   // 버스의 개수

        list = new ArrayList<>();
        for (int i = 0; i < MAX_V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int w = sc.nextInt();

            list.get(x).add(new Pair(y, w));

        }

        int from = sc.nextInt() - 1;    // 출발점
        int to = sc.nextInt() - 1;  // 도착점


        dijkstra(from);


        // print
        System.out.println(dist[to]);


    }

    public static void dijkstra(int from) {
        dist = new int[MAX_V];
        Arrays.fill(dist, INF);

        visit = new boolean[MAX_V];

        dist[from] = 0;

        priorityQueue.add(new Pair(from, 0));

        while (!priorityQueue.isEmpty()) {

            int cur = priorityQueue.peek().pos;

            priorityQueue.poll();

            List<Pair> adj = list.get(cur);
            for (Pair pair : adj) {
                int next = pair.pos;
                int d = pair.dist;

                if (dist[next] > dist[cur] + d) {
                    dist[next] = dist[cur] + d;
                    priorityQueue.add(new Pair(next, dist[next]));
                }
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
