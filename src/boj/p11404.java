package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
플로이드-와샬 DP
모든 정점 쌍 간의 거리를 구할때
O(V^3)
 */
public class p11404 {
    static int n, m;
    static int[][] dist;
    public static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        dist = new int[100][100];

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());


            dist[from][to] = Math.min(cost, dist[from][to]);
        }

        for (int k = 0; k < n; k++) {   // k번째 정점까지만 사용했을때
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // k번째 정점을 우회해서 가는 최단경로가 있는지
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int output = dist[i][j] >= INF ? 0 : dist[i][j];
                System.out.print(output + " ");
            }
            System.out.println();
        }


    }
}
