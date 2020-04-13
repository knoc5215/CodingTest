package swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p1209 {
    static int max;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int test_case = 1; test_case <= 10; test_case++) {
            int T = sc.nextInt();
            max = -1;
            arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            List<Integer> list = new ArrayList<>();
            list.add(getRow());
            list.add(getCol());
            list.add(getCrossRight());
            list.add(getCrossLeft());

            Collections.sort(list);

            System.out.println("#" + T + " " + list.get(list.size() - 1));
        }
    }

    static int getRow() {
        int rowMax = -1;

        for (int row = 0; row < 100; row++) {
            int sum = 0;
            for (int col = 0; col < 100; col++) {
                sum += arr[row][col];
            }
            rowMax = Math.max(rowMax, sum);
        }

        return rowMax;
    }

    static int getCol() {
        int colMax = -1;

        for (int col = 0; col < 100; col++) {
            int sum = 0;
            for (int row = 0; row < 100; row++) {
                sum += arr[row][col];
            }
            colMax = Math.max(colMax, sum);
        }

        return colMax;
    }

    static int getCrossRight() {
        int sum = 0;
        for (int row = 0; row < 100; row++) {
            sum += arr[row][row];
        }

        return sum;
    }

    static int getCrossLeft() {
        int sum = 0;
        for (int i = 99; i >= 0; i--) {
            sum += arr[99 - i][i];
        }
        return sum;
    }
}
