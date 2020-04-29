package leetcode.array;

import java.util.*;

public class TowSum2_Input_array_is_sorted {
    public static void main(String[] args) {
        int[] ret = twoSum(new int[]{2, 7, 11, 15}, 9);
//        int[] ret = twoSum(new int[]{0, 0, 3, 4}, 0);
//        int[] ret = twoSum(new int[]{2, 3, 4}, 6);
//        int[] ret = twoSum(new int[]{-1, 0}, -1);

    }

    public static int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();


        int[] ret = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int complete = target - numbers[i];
            System.out.println("complete : " + complete);

            if (map.containsKey(complete)) {
                ret[0] = i + 1;
                ret[1] = map.get(complete) + 1;
                break;
            } else {
                map.put(numbers[i], i);

            }
        }

        List<Integer> list = new ArrayList<>();
        for (int val : ret) {
//          System.out.print(val + " ");
            list.add(val);
        }

        Collections.reverse(list);

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
            System.out.print(result[i] + " ");
        }
        System.out.println();

        return result;
    }

}
