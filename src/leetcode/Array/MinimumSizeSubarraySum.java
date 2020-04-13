package leetcode.Array;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;

        System.out.println(minSubArrayLen2(s, nums));

    }


    public static int minSubArrayLen2(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int cnt = 1;

            if (cur == s) {
                System.out.println("cur is same with s...return");
                return cnt;
            }
            System.out.println("[current value is = " + cur + "]");

            int sum = cur;
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                System.out.println();
                sum += next;
                System.out.println("current sum is " + sum);

                if (sum < s) {
                    System.out.println("\t need more element...");
                    cnt++;
                } else {
                    cnt++;
                    System.out.println("sum is same with s....cnt = " + cnt);
                    min = Math.min(min, cnt);
                    break;
                }
            }

        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("There is not answer");
            min = 0;
        }

        return min;
    }
}
