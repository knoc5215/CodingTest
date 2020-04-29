package leetcode.array;

import java.util.Arrays;

public class LargestNumberAtLeastTwiceofOthers {
    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{1, 0}));
    }

    public static int dominantIndex(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copy);
        int max = copy[copy.length - 1];

        System.out.println("max is " + max);

        int[] arr = new int[max + 1];
        System.out.println("INDEX ARRAY");
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = i;
            System.out.println("arr[" + nums[i] + "] = " + arr[nums[i]]);
        }
        System.out.println();


        for (int i = copy.length - 2; i >= 0; i--) {
            int cur = copy[i];
            System.out.println("current is " + cur);

            if (max < cur * 2) {
                return -1;
            }
        }
        return arr[max];
    }


}
