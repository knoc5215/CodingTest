package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1074 {
    static int N, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int len = (int) Math.pow(2, N);
        int fromX = 0;
        int fromY = 0;

        search(fromX, fromY, len);

    }

    static void search(int x, int y, int len) {
        if (len == 1) {
            if (x == r && y == c) {
                System.out.println(count);
            }
            count++;
            return;
        }
        int divide = len / 2;
        search(x, y, divide);       // 1사분면
        search(x, y + divide, divide);  // 2사분면
        search(x + divide, y, divide);  // 3사분면
        search(x + divide, y + divide, divide); // 4사분면
    }
}
