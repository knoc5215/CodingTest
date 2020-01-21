package leetcode.Array;

import java.util.*;

public class TowSum2_Input_array_is_sorted {
    public static void main(String[] args) {
//         int[] ret = twoSum(new int[]{2, 7, 11, 15}, 9);
//        int[] ret = twoSum(new int[]{0, 0, 3, 4}, 0);
        int[] ret = twoSum(new int[]{2, 3, 4}, 6);

    }

    public static int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);

        int[] indexArray = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {

            int a = numbers[i];
            int b = numbers[i + 1];
            System.out.println("a is " + numbers[i]);
            System.out.println("b is " + numbers[i + 1]);

            if (b < target && (i + 1) == numbers.length - 1) {
                indexArray[0] = i;
                indexArray[1] = i + 1 + 1;
                for (int val : indexArray) {
                    System.out.print(val + " ");
                }
                return indexArray;
            }

            if (a <= target && target <= b) {
                System.out.println("\t find");
                indexArray[0] = i;
                indexArray[1] = (i + 1);


                for (int val : indexArray) {
                    System.out.print(val + " ");
                }

                return indexArray;

            }

        }
        return null;


    }
}
