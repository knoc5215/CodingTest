package programmers.kakao_previous.blind_2018;

public class Friends4Block_1st {
    static char[][] map;
    static boolean[][] visit;
    static int R, C;

    public static void main(String[] args) {
        R = 4;
        C = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        int ans = solution(R, C, board);
        System.out.println(ans);

    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new char[R][C];
        initMap(board);

        while (true) {
            printMap();
            visit = new boolean[R][C];  // 삭제대상 체크
            int check = 0;  // 몇개가 삭제대상으로 찍혔는지

            for (int r = 0; r < R - 1; r++) {
                for (int c = 0; c < C - 1; c++) {
                    char ch = map[r][c];
                    char right = map[r][c + 1];
                    char cross = map[r + 1][c + 1];
                    char down = map[r + 1][c];
                    if (ch == ' ') continue;    // 빈공간은 대상이 아니다
                    if (ch == right && ch == cross && ch == down) { // 오른쪽, 대각선, 아래가 같으면
                        visit[r][c] = true;
                        visit[r][c + 1] = true;
                        visit[r + 1][c + 1] = true;
                        visit[r + 1][c] = true;

                        check++;    // 삭제대상 카운트 증가
                    }
                }
            }
            if (check == 0) {   // 삭제대상이 없으면
                break;  // while 종료
            }
            int delCnt = delete();  // 삭제 카운트
            answer += delCnt;   // 누적합
            down(); // 밑으로 내려줌
        }
        return answer;
    }

    // 삭제
    static int delete() {
        int delCnt = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (visit[r][c]) {
                    map[r][c] = ' ';
                    delCnt++;
                }
            }
        }
        return delCnt;
    }


    static void initMap(String[] board) {
        for (int i = 0; i < board.length; i++) {
            String row = board[i];
            for (int j = 0; j < row.length(); j++) {
                char ch = row.charAt(j);
                map[i][j] = ch;
            }
        }
    }

    // 밑으로 내리기
    static void down() {
        for (int c = 0; c < C; c++) {
            for (int r = R - 1; r >= 0; r--) {
                if (map[r][c] == ' ') {
                    for (int i = r - 1; i >= 0; i--) {
                        if (map[i][c] != ' ') {
                            map[r][c] = map[i][c];
                            map[i][c] = ' ';
                            break;
                        }
                    }
                }
            }
        }
    }

    static void printMap() {
        System.out.println("============printMap============");
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
