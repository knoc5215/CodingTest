package boj;

import java.util.Arrays;
import java.util.Scanner;

public class p2096 {
    static int n;
    static int[][] arr;
    static int[][] dpMAX, dpMIN;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dpMAX = new int[n][3];
        dpMIN = new int[n][3];

        for (int col = 0; col < 3; col++) {
            dpMAX[0][col] = arr[0][col];
            dpMIN[0][col] = arr[0][col];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dpMAX[i][j] = arr[i][0] + Math.max(dpMAX[i - 1][0], dpMAX[i - 1][1]);
                    dpMIN[i][j] = arr[i][0] + Math.min(dpMIN[i - 1][0], dpMIN[i - 1][1]);
                } else if (j == 2) {
                    dpMAX[i][j] = arr[i][2] + Math.max(dpMAX[i - 1][1], dpMAX[i - 1][2]);
                    dpMIN[i][j] = arr[i][2] + Math.min(dpMIN[i - 1][1], dpMIN[i - 1][2]);
                } else {
                    dpMAX[i][j] = arr[i][1] + Math.max(Math.max(dpMAX[i - 1][0], dpMAX[i - 1][1]), dpMAX[i - 1][2]);
                    dpMIN[i][j] = arr[i][1] + Math.min(Math.min(dpMIN[i - 1][0], dpMIN[i - 1][1]), dpMIN[i - 1][2]);
                }
            }
        }


        int[] maxArr = dpMAX[n - 1];
        int[] minArr = dpMIN[n - 1];

        Arrays.sort(maxArr);
        Arrays.sort(minArr);

        System.out.println(maxArr[maxArr.length - 1] + " " + minArr[0]);

    }
}
