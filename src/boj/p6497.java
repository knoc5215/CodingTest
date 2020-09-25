package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p6497 {
    static int m, n;
    static Edge[] edges;
    static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());  // 집(정점)의 개수
            n = Integer.parseInt(st.nextToken());  // 길(간선)의 개수

            if (m == 0 && n == 0) {
                return;
            }

            unionFind = new int[m];
            for (int i = 0; i < m; i++) {
                unionFind[i] = i;
            }

            edges = new Edge[n];
            int allCost = 0;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(x, y, z);
                allCost += z;   // 모든 간선들의 비용 총합
            }

            Arrays.sort(edges, ((o1, o2) -> o1.w - o2.w));
            int mstCost = 0;    // MST 비용
            int pickCnt = 0;
            for (int k = 0; k < edges.length; k++) {
                Edge edge = edges[k];
                if (union(edge.u, edge.v)) {
                    mstCost += edge.w;
                    if (++pickCnt == m - 1) {
                        break;
                    }
                }
            }

            System.out.println(allCost - mstCost);  // 전체 비용에서 - 이어진 곳을 제외한 것은 = 소등해도 괜찮은 곳  = 절약 최대치


        }


    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        } else {
            unionFind[b] = a;
            return true;
        }
    }

    static int find(int a) {
        if (unionFind[a] == a) {
            return a;
        } else {
            return unionFind[a] = find(unionFind[a]);
        }
    }

    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "u=" + u +
                    ", v=" + v +
                    ", w=" + w +
                    '}';
        }
    }
}
