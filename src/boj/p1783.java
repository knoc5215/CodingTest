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

        if (N == 1)         // 제자리 카운트 1
            moveCnt = 1;
        else if (N == 2)    // N이 2일때 최대 얼마나 갈 수 있는지
            moveCnt = Math.min(4, (M + 1) / 2);
        else if (M < 7)     // 4가지 방법을 모두 사용했을 때 얼마나 갈 수 있는지
            moveCnt = Math.min(4, M);
        else                // 나머지 경우
            moveCnt = M - 2;

        System.out.println(moveCnt);


    }
}
