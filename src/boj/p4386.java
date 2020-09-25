package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class p4386 {
    static int n;
    static Star[] stars;
    static List<Edge> edgeList = new ArrayList<>();
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        stars = new Star[n + 1];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            stars[i] = new Star(a, b);

            double x1 = stars[i].a;
            double y1 = stars[i].b;

            // 모든 별자리 쌍에 대한 간선을 추가
            for (int j = 1; j < i; j++) {
                double x2 = stars[j].a;
                double y2 = stars[j].b;
                edgeList.add(new Edge(i, j, getDist(x1, y1, x2, y2)));
            }
        }

        edgeList.sort(((o1, o2) -> (int) (o1.w - o2.w)));

        parents = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parents[i] = i;
        }

        // 크루스칼
        double mstCost = 0;
        int pickCnt = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (union(edge.u, edge.v)) {
                mstCost += edge.w;
                if (++pickCnt == n - 1) {
                    break;
                }
            }
        }

        System.out.printf("%.2f%n", mstCost);


    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return false;
        } else {
            parents[b] = a;
            return true;
        }
    }

    static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = find(parents[a]);
        }
    }

    static double getDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    static class Edge {
        int u, v;
        double w;

        public Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class Star {
        double a, b;

        public Star(double a, double b) {
            this.a = a;
            this.b = b;
        }
    }
}
