package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
    촌수계산
 */
public class p2644 {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 전체 사람의 수
        map = new int[N + 1][N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(visit, false);
        dist = new int[N + 1];
        Arrays.fill(dist, 0);

        int from, to = -1;
        String[] str = br.readLine().split(" ");    // 촌수 계산 두 사람의 번호
        from = Integer.parseInt(str[0]);
        to = Integer.parseInt(str[1]);

        int M = Integer.parseInt(br.readLine());    // 부모-자식 관계 수
        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");    // 부모-자식 관계 (x는 y의 부모이다)
            int x = Integer.parseInt(str[0]);   // 부모
            int y = Integer.parseInt(str[1]);   // 자식

            map[x][y] = 1;  // 관계 존재
            map[y][x] = 1;
        }


        sol(from, to);

        if (dist[to] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dist[to]);
        }

    }

    public static void sol(int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visit[from] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == to) {
                break;
            }

            for (int i = 1; i <= N; i++) {
                if (map[curr][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                    dist[i] = dist[curr] + 1;
                }
            }
        }

    }


}
