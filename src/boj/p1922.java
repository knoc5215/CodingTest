package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p1922 {
    static int N, M;
    static Edge[] edges;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점의 개수

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());  // 간선의 개수
        edges = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, c);
        }

        parents = new int[N];   // union-find parents array init
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        Arrays.sort(edges, (o1, o2) -> o1.w - o2.w);    // 가중치 오름차순으로 정렬

        int mstCost = 0;
        int pickCnt = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (union(edge.u, edge.v)) { // 같은 컴포넌트가 아니라면
                mstCost += edge.w;  // 간선을 MST에 추가해준다
                pickCnt++;  // 뽑은 간선의 개수 증가

                if (pickCnt == N - 1) {    // MST 간선의 개수 = 정점의 개수 - 1 --> 모두 뽑았다면 break
                    break;
                }
            }
        }

        System.out.println(mstCost);    // MST를 구성하는 최소비용 출력


    }

    static int find(int a) {
        if (parents[a] == a)
            return a;
        else
            return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b)
            return false;   // 같은 부모라면 false
        else {
            parents[b] = a; // b를 a의 자식으로
            return true;
        }
    }

    static class Edge {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
