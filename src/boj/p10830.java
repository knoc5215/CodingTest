package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10830 {
    static int N;
    static int MOD = 1000;
    static int[][] unitMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        unitMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            unitMatrix[i][i] = 1;
        }

        matrix = pow(B, matrix);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static int[][] pow(long b, int[][] matrix) {
        if (b == 0) {
            return unitMatrix;  // 단위행렬
        }
        if (b == 1) {
            return matrix;  // 자기자신
        }

        int[][] newMatrix = pow(b / 2, matrix);
        newMatrix = multiple(newMatrix, newMatrix);

        return b % 2 == 0 ? newMatrix : multiple(newMatrix, matrix);

    }

    private static int[][] multiple(int[][] matrix1, int[][] matrix2) {
        int[][] resultMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                resultMatrix[i][j] %= MOD;
            }
        }

        return resultMatrix;
    }


}
