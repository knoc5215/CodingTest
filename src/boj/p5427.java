package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5427 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int exitTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = stoi(st.nextToken());
            M = stoi(st.nextToken());

            Queue<Node> fires = new LinkedList<>();
            Node person = null;

            map = new int[M + 2][N + 2];
            for (int i = 1; i < M + 1; i++) {
                String input = br.readLine();
                for (int j = 1; j < N + 1; j++) {
                    char ch = input.charAt(j - 1);
                    if (ch == '#') { //벽
                        map[i][j] = -1;
                    } else if (ch == '@') { //상근이의 위치
                        person = new Node(i, j, 0);
                    } else if (ch == '*') {  //불
                        map[i][j] = -1;
                        fires.add(new Node(i, j));
                    }
                }
            }

            exitTime = Integer.MAX_VALUE;
            BFS(person, fires);

            System.out.println(exitTime == Integer.MAX_VALUE ? "IMPOSSIBLE" : exitTime);

        }
    }

    static void BFS(Node person, Queue<Node> fires) {
        Queue<Node> queue = new LinkedList<>();

        map[person.x][person.y] = 1;
        queue.add(person);

        while (!queue.isEmpty()) {

            //상근이가 있는 칸에 불이 옮겨옴과 동시에 다른 칸으로 이동할 수 있다.
            //불을 먼저 퍼트리고
            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++) {
                Node fire = fires.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = fire.x + dx[j];
                    int ny = fire.y + dy[j];
                    // 불이 아직 퍼지지 않았거나, 벽이 아니거나
                    if (1 <= nx && nx < M + 1 && 1 <= ny && ny < N + 1 && map[nx][ny] != -1) {
                        map[nx][ny] = -1;
                        fires.add(new Node(nx, ny));
                    }
                }
            }

            //상근이가 이동한다
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node cur = queue.poll();
                // 경계(탈출구)에 도착하면 끝난다
                if (cur.x == 0 || cur.x == M + 1 || cur.y == 0 || cur.y == N + 1) {
                    exitTime = Math.min(exitTime, cur.time);
                } else {
                    for (int j = 0; j < 4; j++) {
                        int nx = cur.x + dx[j];
                        int ny = cur.y + dy[j];
                        //벽이나 불이 아니면서 상근이가 방문한 곳이 아니라면
                        if (nx >= 0 && ny >= 0 && nx <= M + 1 && ny <= N + 1 && map[nx][ny] != -1 && map[nx][ny] != 1) {
                            map[nx][ny] = 1;    //방문처리
                            queue.add(new Node(nx, ny, cur.time + 1));
                        }
                    }
                }
            }
        }

    }


    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node {
        int x, y, time;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }


}
