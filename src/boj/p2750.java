package boj;

import java.util.Scanner;

public class p2750 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n]; // 5 2 3 4 1
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//        selection_sort(arr);
//        insertion_sort(arr);
        bubble_sort(arr);
        for (int val : arr) {
            System.out.println(val);
        }


    }

    private static void bubble_sort(int[] arr) {
        int len = arr.length;

        for (int i = len - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void selection_sort(int[] arr) {
        int len = arr.length;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[i]) {
                    swap(arr, j - 1, i);
                }
            }
        }
    }

    private static void insertion_sort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }

        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
