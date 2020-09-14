package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
숨바꼭질 3
 */
public class p13549 {
    static int N, K;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[100002];    // 0 ~ 100,000

        queue.add(new Node(N, 0));  // 시작점

        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == K) {
                min = Math.min(min, cur.time);
                break;
            }

            if (visit[cur.x]) continue;
            visit[cur.x] = true;

            int back = cur.x - 1;   // 반례가 있다
            int jump = cur.x * 2;
            int front = cur.x + 1;

            // 범위체크 후 방문체크 순서 고려

            if (isRange(back) && !visit[back]) {
                queue.add(new Node(back, cur.time + 1));
            }

            if (isRange(jump) && !visit[jump]) {
                queue.add(new Node(jump, cur.time));
            }

            if (isRange(front) && !visit[front]) {
                queue.add(new Node(front, cur.time + 1));
            }


        }

        System.out.println(min);

    }

    static boolean isRange(int x) {
        return 0 <= x && x <= 100000;
    }

    static class Node {
        int x, time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}
