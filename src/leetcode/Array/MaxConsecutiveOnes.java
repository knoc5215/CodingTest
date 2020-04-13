package leetcode.Array;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
//        System.out.println("ret = " + findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
//        System.out.println("ret = " + findMaxConsecutiveOnes(new int[]{0}));
        System.out.println("ret = " + findMaxConsecutiveOnes(new int[]{0, 0, 0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {

        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            int cur = nums[i];
            if (cur == 0) {
                continue;
            }

            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                int next = nums[j];
                if (next == cur) {
                    count++;
                } else {
                    break;
                }
            }

            max = Math.max(max, count);

        }

        return max;
    }

}
