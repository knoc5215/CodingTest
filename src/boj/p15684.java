package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
사다리 게임은 N개의 세로선과 M개의 가로선으로 이루어져 있다.
각각의 세로선마다 가로선을 놓을 수 있는 위치의 개수는 H이고, 모든 세로선이 같은 위치를 갖는다.
사다리에 가로선을 추가해서, 사다리 게임의 결과를 조작하려고 한다.
이때, i번 세로선의 결과가 i번이 나와야 한다.
그렇게 하기 위해서 추가해야 하는 가로선 개수의 최솟값을 구하는 프로그램을 작성하시오.
 */
public class p15684 {
    static int N, M, H;
    static int[][] arr;
    static int ANS = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = stoi(stringTokenizer.nextToken());  //세로선
        M = stoi(stringTokenizer.nextToken());  //가로선
        H = stoi(stringTokenizer.nextToken());  //가로선을 놓을 수 있는 위치의 개수

        arr = new int[H + 1][N + 1];
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int a = stoi(stringTokenizer.nextToken());
            int b = stoi(stringTokenizer.nextToken());
            arr[a][b] = 1;  // 1 = to right
            arr[a][b + 1] = 2; // 2 = to left
        }

        DFS(1, 0);  // 1행부터 돌아보자
        System.out.println((ANS != 4) ? ANS : -1);


    }

    static boolean isSuccess() {
        for (int j = 1; j <= N; j++) {  // 1열부터 시작하면서
            int x = 1;  // 1행
            int y = j;  // 시작 열번호
            for (int i = 0; i < H; i++) {   // 행만큼 루프를 돌면서
                if (arr[x][y] == 1) y++;    // 1이면? 오른쪽으로 간다 -> 열번호++
                else if (arr[x][y] == 2) y--;   // 2이면? 왼쪽으로 간다 -> 열번호++
                x++;                            // 다음행으로 가기위해서 행번호++
            }
            if (y != j) return false;           // j열에서 시작하고, y열에서 끝났는데 다르다면? 실패
        }
        return true;    // 성공
    }

    static void DFS(int row, int count) {
        if (ANS <= count) { // 3개보다 많이 설치했다면 그대로 종료
            return;
        } else {
            if (isSuccess()) {  // i열이 i열에 도착한다면 성공
                ANS = count; // 이 경우의 설치한 사다리 개수 갱신
                return;
            }
        }

        for (int i = row; i < H + 1; i++) { // 1행부터 시작하자
            for (int j = 1; j < N; j++) {   // 행마다는 열은 항상 1번부터 시작
                if (arr[i][j] == 0 && arr[i][j + 1] == 0) { // 가로선을 추가할 수 있다면
                    arr[i][j] = 1;  // 추가한다
                    arr[i][j + 1] = 2;
                    DFS(i, count + 1);  // 더 탐색하고
                    arr[i][j + 1] = 0;  // 백트래킹
                    arr[i][j] = 0;
                }
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
