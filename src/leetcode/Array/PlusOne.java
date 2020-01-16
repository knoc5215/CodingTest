package leetcode.Array;

public class PlusOne {
    public static void main(String[] args) {
//        int[] ret = plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6});
        int[] ret = plusOne(new int[]{9});
    }

    public static int[] plusOne(int[] digits) {
        String numStr = "";
        for (int val : digits) {
            numStr += String.valueOf(val);
        }

        char[] chars = numStr.toCharArray();
        int[] arr = new int[numStr.length()];
        for (int i = 0; i < chars.length; i++) {
            arr[i] = Integer.parseInt(String.valueOf(chars[i]));
        }


        // 99
        StringBuilder sb = new StringBuilder();
        int idx = numStr.length() - 1;

        while (arr[idx] + 1 > 9) {
            arr[idx] = 0;
            idx--;

            if (idx < 0) {
                int[] extendArr = new int[arr.length + 1];
                extendArr[0] = 1;
                for (int i = 0; i < arr.length; i++) {
                    extendArr[i + 1] = arr[i];
                }

                for (int val : extendArr) {
                    System.out.print(val);
                }
                System.out.println();

                return extendArr;
            }

        }

        arr[idx] += 1;

        for (int val : arr) {
            System.out.print(val);
        }
        System.out.println();

        return arr;
    }
}
