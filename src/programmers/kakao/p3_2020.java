package programmers.kakao;

/*
자물쇠와 열쇠
 */
public class p3_2020 {
    static boolean answer = false;

    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));

    }

    /*
        0 홈, 1 돌기
        M<=N

     */
    public static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;
        int[][] expandLock = new int[len * 3][len * 3];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                expandLock[i + len][j + len] = lock[i][j];
            }
        }

        DFS(key, expandLock, 0);
        return answer;
    }

    static void DFS(int[][] key, int[][] lock, int count) {
        checkKey(key, lock, 0, 0);
        if (answer) return;
        if (count >= 4) return;
        DFS(rotateKey(key), lock, count + 1);
    }

    static void checkKey(int[][] key, int[][] lock, int x, int y) {
        if (answer) return;

        if (lock.length < key.length + y) { // 열 범위를 초과하면
            y = 0;  // 열 처음으로
            x++;    // 다음 행으로
        }

        if (lock.length < key.length + x) return;   // 마지막 행이라면 종료

        int[][] copyLock = new int[lock.length][lock.length];
        for (int i = 0; i < lock.length; i++) {
            copyLock[i] = lock[i].clone();
        }

        boolean isFail = false;
        loop:
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if (key[i][j] == 1) {   // key가 돌기인데
                    if (copyLock[i + x][j + y] == 1) {  // 자물쇠도 돌기이면
                        isFail = true;
                        break loop;
                    }
                    copyLock[i + x][j + y] = key[i][j]; // key의 돌기와 자물쇠의 홈이 만나면 홈을 1(돌기)로 채운다
                }
            }
        }

        if (!isFail) {
            loop:
            for (int i = 0; i < lock.length / 3; i++) {
                for (int j = 0; j < lock.length / 3; j++) {
                    if (copyLock[i + lock.length / 3][j + lock.length / 3] != 1) {  // 돌기로 안채워진 홈이 자물쇠에 존재하면
                        isFail = true;  // 실패
                        break loop;
                    }
                }
            }
        }

        if (!isFail) {
            answer = true;
        }

        checkKey(key, lock, x, y + 1);  // 오른쪽으로 한칸 이동해서 다시 check

    }

    public static int[][] rotateKey(int[][] key) {
        int N = key.length;
        int[][] rotate = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotate[i][j] = key[N - 1 - j][i];
            }
        }
        return rotate;
    }


}
