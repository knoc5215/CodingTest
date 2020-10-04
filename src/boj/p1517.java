package boj;

import java.util.Scanner;

public class p1517 {
    static int n;
    static long[] sorted;
    static long cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sorted = new long[n];

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        mergeSort(arr, 0, n - 1);

        System.out.println(cnt);


    }

    static void merge(long[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int idx = low;

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                sorted[idx++] = arr[i++];
            } else {
                sorted[idx++] = arr[j++];
                cnt += (mid + 1 - i);   // 왼쪽 리스트의 값이 오른쪽 리스트의 값보다 큰 경우 왼쪽 list의 크기에 그 값의 index를 빼면 큰 수의 개수
                // https://hoho325.tistory.com/136 참고
            }
        }

        while (i <= mid) {
            sorted[idx++] = arr[i++];
        }

        while (j <= high) {
            sorted[idx++] = arr[j++];
        }

        for (int k = low; k <= high; k++) {
            arr[k] = sorted[k];
        }
    }

    static void mergeSort(long[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }


}
