package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class p10798 {
    static int R = 5;   // 최대행
    static int C = 15;  // 최대열
    static char[][] matrix = new char[R][C];
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < R; i++) {
            char[] row = br.readLine().toCharArray();
            System.arraycopy(row, 0, matrix[i], 0, row.length);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isRange(matrix[i][j])) {   // 유효한 문자가 아니라면, 공백문자로 초기화
                    matrix[i][j] = ' ';
                }
            }
        }

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (matrix[r][c] != ' ')    // 공백이 아닌 것만
                    stringBuilder.append(matrix[r][c]);
            }
        }

        System.out.println(stringBuilder.toString().trim());

    }

    private static boolean isRange(char ch) {
        return ('0' <= ch && ch <= '9') || ('A' <= ch && ch <= 'Z') || ('a' <= ch && ch <= 'z');
    }


}
