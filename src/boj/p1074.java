package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1074 {
    static int N, r, c;
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 0, 1};

    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        int size = (int) Math.pow(2, N);

        checkArray(size, 0, 0, 0);


    }

    private static void checkArray(int n, int x, int y, int cnt) {

        if (x > r || x + n <= r || y > c || y + n <= c) {   // 예상범위 밖이면 리턴
            return;
        }
        if (n == 2) {   // 2*2 사이즈까지 도달했을때

            for (int i = 0; i < 4; i++) {   // 1~4 사분면 좌표값 계산
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == r && ny == c) {   // 찾고자 하는 좌표라면
                    System.out.println(cnt + i);    // 1사분면이 i == 0 이니까 cnt 갱신해서 출력해준다
                }
            }
            return;
        }


        int next = n / 2;   // 다음 분할 사이즈

        checkArray(next, x, y, cnt);    // 1사분면
        checkArray(next, x, y + next, cnt + (next * next)); // 2사분면
        checkArray(next, x + next, y, cnt + (next * next * 2)); // 3사분면
        checkArray(next, x + next, y + next, cnt + (next * next * 3)); //4사분면

    }


}
