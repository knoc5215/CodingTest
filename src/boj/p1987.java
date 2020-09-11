package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p1987 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C;
    static char[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String string = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = string.charAt(j);
            }
        }
        Set<Character> set = new HashSet<>();
        set.add(map[0][0]);
        DFS(0, 0, 1, set);

        System.out.println(max);


    }

    static void DFS(int x, int y, int depth, Set<Character> set) {

        max = Math.max(max, depth);

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isRange(nx, ny)) continue;

            char next = map[nx][ny];

            if (set.contains(next)) continue;    // 처음으로 지나가는 알파벳이라면
            set.add(next);  // 지나갔다고 기록해준다
            DFS(nx, ny, depth + 1, set);

            set.remove(next);   // 백트래킹

        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < R && 0 <= y && y < C;
    }
}
