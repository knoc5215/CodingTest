package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://do-rang.tistory.com/70 참고
public class p1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int moveCnt = 0;

        if (N == 1) {
            moveCnt = 1;
        } else if (N == 2) {
            moveCnt = (M - 1) / 2;
            moveCnt = Math.min(moveCnt, 3);
        } else if (M < 7) {
            moveCnt = M - 1;
            moveCnt = Math.max(moveCnt, 3);
        } else {
            moveCnt = 4 + M - 7;
        }

        System.out.println(moveCnt+1);


    }
}
