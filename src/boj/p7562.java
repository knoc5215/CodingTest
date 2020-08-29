package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p7562 {
    static int[][] map;
    static int I;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static Node night, dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            I = Integer.parseInt(br.readLine());
            map = new int[I][I];

            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            night = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            input = br.readLine();
            st = new StringTokenizer(input, " ");
            dest = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            System.out.println(solution(map));


        }


    }

    static int solution(int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(night);

        boolean[][] visit = new boolean[I][I];
        visit[night.x][night.y] = true;

        int ans = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.peek();
            if (cur.x == dest.x && cur.y == dest.y) {
//                ans = map[cur.x][cur.y];
                ans = cur.depth;
                break;
            }

            cur = queue.poll();
            for (int dir = 0; dir < 8; dir++) {
                int nx = cur.x + dx[dir];
                int ny = cur.y + dy[dir];

                if (isRange(nx, ny) && !visit[nx][ny]) {
                    Node next = new Node(nx, ny, cur.depth+1);
                    visit[nx][ny] = true;
                    queue.add(next);
//                    map[nx][ny] = map[cur.x][cur.y] + 1;
                }
            }


        }

        return ans;

    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < I && 0 <= y && y < I;
    }

    static class Node {
        int x, y, depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

}
