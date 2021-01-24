package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9521 {
    public static final int INF = 1000000007;
    static int N, K;
    static long ans = 1;

    static long[] colors = new long[1000001];
    static int[] first_visit = new int[1000001];
    static int[] visit = new int[1000001];
    static int[] func = new int[1000001];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            func[i + 1] = Integer.parseInt(st.nextToken());
        }

        colors[0] = 1;
        colors[1] = K;
        colors[2] = ((long) K * (K - 1)) % INF;
        colors[3] = ((long) K * (K - 1) * (K - 2)) % INF;

        for (int i = 4; i <= N; i++) {
            colors[i] = colors[i - 2] * (K - 1) + colors[i - 1] * (K - 2);
            colors[i] %= INF;
        }

        int single_cnt = N; // 사이클이 아닌 정점의 수
        int cycle_cnt;  // 사이클을 구성하는 정점의 수
        for (int i = 1; i <= N; i++) {
            if (visit[i] == 0) {    // 방문한 적이 없으면
                cycle_cnt = DFS(i, i, 1);   //  사이클을 구하고

                ans *= colors[cycle_cnt];   // 사이클을 구성하는 N개의 정점을 색칠할 수 있는 경우의 수를 구한다
                ans %= INF;

                single_cnt -= cycle_cnt;    // 사이클 색칠을 끝냈으니 사이클이 아닌 정점의 수를 갱신
            }
        }

        for (int i = 1; i <= single_cnt; i++) { // 사이클에 포함되지 않는 정점들에 대해서
            ans *= (K - 1); // 경우의 수 구하기
            ans %= INF;
        }

        System.out.println(ans);


    }

    private static int DFS(int from, int current, int cnt) {
        if (visit[current] > 0) {
            if (first_visit[current] != from) {
                return 0;
            }

            return cnt - visit[current];
        }

        visit[current] = cnt;
        first_visit[current] = from;

        return DFS(from, func[current], cnt + 1);
    }
}
