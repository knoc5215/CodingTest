package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때
그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
 */
public class p1707 {
    static int V, E;
    static int[] colors;
    public static final int RED = 1;
    public static final int BLUE = -1;
    static ArrayList<ArrayList<Integer>> arrayLists;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            arrayLists = new ArrayList<>();
            colors = new int[V + 1];
            isBipartite = true;

            for (int i = 0; i < V + 1; i++) {
                arrayLists.add(new ArrayList<Integer>());
                colors[i] = 0;  // 방문하지 않은 정점은 0으로 초기화
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arrayLists.get(from).add(to);
                arrayLists.get(to).add(from);
            }

            for (int i = 1; i < V + 1; i++) {
                if (!isBipartite) {
                    break;
                }

                if (colors[i] == 0) {
//                    DFS(i, RED);
                    BFS(i, RED);
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");


        }


    }

    static void DFS(int startV, int color) {
        colors[startV] = color;

        for (int adjV : arrayLists.get(startV)) {
            if (colors[adjV] == color) {
                isBipartite = false;
                return;
            }

            if (colors[adjV] == 0) {
                DFS(adjV, -color);
            }
        }
    }

    static void BFS(int startV, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startV);
        colors[startV] = color;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int adjV : arrayLists.get(v)) {
                if (colors[adjV] == 0) {
                    colors[adjV] = colors[v] * -1;
                    queue.add(adjV);
                } else if (colors[v] + colors[adjV] != 0) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}
