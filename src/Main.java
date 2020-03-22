import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] people, election;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        people = new int[N+1][N+1];
        election = new int[N+1][N+1];

        StringTokenizer st;
        for(int i = 1 ; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= N ; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x = 1 ; x <= N; x++) {
            for(int y = 1 ; y <= N ; y++) {
                // 모든 d1, d2에 대해서 
                for(int d1 = 1 ; d1 < N*2 ; d1++) {
                    for(int d2 = 1 ; d2 < N * 2 ; d2++) {

                        if(x + d1 + d2 <= N && 1 <= y-d1 && y+d2 <= N) {
                            // d1, d2에 따라 12345 구역 설정 
                            select1(x, y, d1, d2);
                            select2(x, y, d1, d2);
                            select3(x, y, d1, d2);
                            select4(x, y, d1, d2);
                            select5(x, y, d1, d2);

                            // 구역 최대, 최소 개수 세기 
                            count();
                        }
                    }
                }
            }
        }
        System.out.println(ans);

    }
    static void select1(int x, int y, int d1, int d2) { // 1 구역 색칠 
        for(int r = 1; r < x + d1; r++) {
            for(int c = 1 ; c <= y; c++) {
                election[r][c] = 1;
            }
        }
    }
    static void select2(int x, int y, int d1, int d2) { // 2 구역 색칠 
        for(int r = 1; r <= x + d2 ; r++) {
            for(int c = y+1 ; c <= N ; c++) {
                election[r][c] = 2;
            }
        }
    }
    static void select3(int x, int y, int d1, int d2) { // 3 구역 색칠 
        for(int r = x+d1; r <= N; r++) {
            for(int c = 1 ; c < y-d1+d2 ; c++) {
                election[r][c] = 3;
            }
        }
    }
    static void select4(int x, int y, int d1, int d2) { // 4 구역 색칠 
        for(int r = x+d2+1; r <= N ; r++) {
            for(int c = y-d1+d2 ; c <= N; c++) {
                election[r][c] = 4;
            }
        }
    }

    static void select5(int x, int y, int d1, int d2) { // 5 구역 색칠 

        // 경계 색칠 
        for(int alpha = 0 ; alpha <= d1; alpha++) {
            election[x+alpha][y-alpha] = 5;
        }
        for(int alpha = 0 ; alpha <= d2; alpha++) {
            election[x+alpha][y+alpha] = 5;
        }
        for(int alpha = 0 ; alpha <= d2; alpha++) {
            election[x+d1+alpha][y-d1+alpha] = 5;
        }
        for(int alpha = 0 ; alpha <= d1; alpha++) {
            election[x+d2+alpha][y+d2-alpha] = 5;
        }

        // 내부 색칠, 마름모 모양이기 때문에 마지막 끝은 제외.
        for(int alpha = 0 ; alpha < d1; alpha++) {
            inner5(x+alpha+1, y-alpha);
        }
        for(int alpha = 0 ; alpha < d2; alpha++) {
            inner5(x+alpha+1, y+alpha);
        }

    }

    static int[][] delta = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };
    // 5구역 내부 
    static void inner5(int x, int y) {
        election[x][y] = 5;

        int ny, nx;
        for(int dir = 0 ; dir < 4; dir++) {
            nx = x + delta[dir][1];
            ny = y + delta[dir][0];
            if(ny > 0 && ny <= N && nx > 0 && nx <= N && election[nx][ny] != 5) {
                inner5(nx, ny);
            }
        }
    }

    static int ans = 987654321;
    // 구역 수를 세고, 최대 최소를 이용하여 답 구한다.
    static void count() {

        // counts[i]: i번 구역의 인구 수 
        int[] counts = new int[6];
        for(int r = 1 ; r <= N; r++) {
            for(int c= 1 ; c<= N; c++) {
                counts[election[r][c]] += people[r][c];
                people[r][c] = 1;
            }
        }

        int min = 987654321, max = -1;
        for(int i = 1 ; i <= 5 ; i++) {
            if(min > counts[i]) {
                min = counts[i];
            }
            if(max < counts[i]) {
                max = counts[i];
            }
        }
        if( ans > max - min) {
            ans = max- min;
        }
    }
}