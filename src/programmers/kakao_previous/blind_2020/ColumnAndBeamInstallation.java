package programmers.kakao_previous.blind_2020;

/*
기둥과 보 설치
 */
public class ColumnAndBeamInstallation {
    private boolean[][] column, beam;
    private int n;
    private final int COLUMN = 0, BEAM = 1, REMOVE = 0, ADD = 1;

    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        int count = 0;
        column = new boolean[n + 3][n + 3];
        beam = new boolean[n + 3][n + 3];

        for (int[] frame : build_frame) {
            int x = frame[0] + 1;
            int y = frame[1] + 1;

            if (frame[2] == COLUMN) {
                if (frame[3] == ADD && isExistCol(x, y)) {
                    column[x][y] = true;
                    count++;
                }
                if (frame[3] == REMOVE && canRemove(x, y, COLUMN)) {
                    column[x][y] = false;
                    count--;
                }
            } else {
                if (frame[3] == ADD && isExistRow(x, y)) {
                    beam[x][y] = true;
                    count++;
                }
                if (frame[3] == REMOVE && canRemove(x, y, BEAM)) {
                    beam[x][y] = false;
                    count--;
                }
            }

        }

        int[][] answer = new int[count][3];
        int idx = 0;
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (column[i][j]) {
                    answer[idx++] = new int[]{i - 1, j - 1, COLUMN};
                }
                if (beam[i][j]) {
                    answer[idx++] = new int[]{i - 1, j - 1, BEAM};
                }
            }
        }
        return answer;


    }

    public boolean canRemove(int x, int y, int type) {
        boolean result = true;

        if (type == COLUMN) {
            column[x][y] = false;
        } else {
            beam[x][y] = false;
        }

        loop:
        for (int i = 1; i <= n + 1; i++) {
            for (int j = 1; j <= n + 1; j++) {
                if (column[i][j] && !isExistCol(i, j)) {
                    result = false;
                    break loop;
                }
                if (beam[i][j] && !isExistRow(i, j)) {
                    result = false;
                    break loop;
                }
            }
        }

        if (type == COLUMN) {
            column[x][y] = true;
        } else {
            beam[x][y] = true;
        }

        return result;
    }

    private boolean isExistCol(int x, int y) {
        return y == 1 || column[x][y - 1] || beam[x][y] || beam[x - 1][y];
    }

    private boolean isExistRow(int x, int y) {
        return column[x][y - 1] || column[x + 1][y - 1] || (beam[x - 1][y] && beam[x + 1][y]);
    }


}





