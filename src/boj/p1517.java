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
                // arr[i] > arr[j] 이라면? 당연히 arr[i+1, i+2, ...] 도 arr[j]보다 큼
                // 분할된 배열들은 각각 정렬된 상태임
                // arr[i+2] > arr[i+1] > arr[i] > arr[j] 관계니까
                // 실제 버블소트의 경우였으면, 모두 교환대상이니 cnt 증가시킬거니까 !!

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
