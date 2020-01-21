package leetcode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int ret = arrayPairSum(new int[]{1, 4, 3, 2, 5, 6, 7, 8});
        System.out.println("result is " + ret);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 2) {
            System.out.println("pair is (" + nums[i] + ", " + nums[i + 1] + ")");
            int min = Math.min(nums[i], nums[i + 1]);
            list.add(min);
        }

        int sum = 0;
        for (int val : list) {
            sum += val;
        }
        return sum;
    }
}
