package boj;

import java.util.Scanner;

public class p2750 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort(0, n - 1);
        for (int val : arr) {
            System.out.println(val);
        }


    }

    static void sort(int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[(i + j) / 2];

        while (i <= j) {
            while (arr[i] < pivot)  // 피벗보다 큰거 찾기
                i++;
            while (pivot < arr[j])  // 피벗보다 작은거 찾기
                j--;

            if (i <= j) {   // 교환
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        if (low < j)        // 피벗보다 작은 부분 재귀호출
            sort(low, j);
        if (high > i)   // 피벗보다 큰 부분 재귀호출
            sort(i, high);
    }
}
