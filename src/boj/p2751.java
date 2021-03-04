package boj;

import java.io.*;

public class p2751 {
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 5 2 3 4 1
        temp = new int[arr.length];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(arr, 0, arr.length - 1);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int val : arr) {
            bw.write(String.valueOf(val));
            bw.newLine();
        }
        bw.flush();
    }

    private static void merge_sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;

        int k = start;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        if (end + 1 - start >= 0) System.arraycopy(temp, start, arr, start, end + 1 - start);
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
