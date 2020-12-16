package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p10871 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] < x) {
                list.add(arr[i]);
            }
        }

        for (int val : list) {
            System.out.print(val + " ");
        }


    }
}
