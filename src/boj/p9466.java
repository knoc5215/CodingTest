package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p9466 {
    static int n;
    static int[] arr;
    static int[] visit;
    static int[] first;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        while (test-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            visit = new int[n + 1]; // 방문 cnt 배열
            first = new int[n + 1]; // 시작점 배열

            for (int i = 1; i <= n; i++) {
                if (visit[i] == 0) {    // 방문한적이 없다면
                    ans += DFS(i, i, 1);    // ans는 사이클을 구성하는 인원
                }
            }

            System.out.println(n - ans);    // 사이클을 만들지 못하는 팀원 (팀을 꾸릴 수 없는 사람 수)

        }
    }

    static int DFS(int start, int cur, int cnt) {
        if (visit[cur] > 0) {   // 이미 방문했다면
            if (first[cur] == start) {  // 현재 cur의 시작점과 start가 같다면 -> 사이클이다
                return cnt - visit[cur];    // 방문 cnt 에서 visit[cur]를 뺀다 -> visit[cur]는 cur를 몇번째로 방문했는지 카운트를 갖고 있음 (현재 카운트에서 빼줘야 갯수 계산)

            } else {
                return 0;
            }

        } else {   // 처음 방문했다면
            first[cur] = start; // 현재 cur가 어디서부터 시작한건지 저장
            visit[cur] = cnt;   // 몇번째 cnt로 방문했는지

            return DFS(start, arr[cur], cnt + 1);

        }
    }
}
