package leetcode.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RotateArray {

    public static void rotate(int[] nums, int k) {


        for (int step = k; step > 0; step--) {
            for (int i = 0; i < nums.length - 1; i++) {
                int temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int val : nums) {
            System.out.print(val + " ");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};    // 5 6 7 1 2 3 4
        int step = 3;

        rotate(arr, step);


    }
}
