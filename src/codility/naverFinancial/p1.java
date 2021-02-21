package codility.naverFinancial;

public class p1 {
    public static void main(String[] args) {
        int[] ret = solution(new String[]{"gr", "sd", "rg"});
        for (int val : ret) {
            System.out.print(val + " ");
        }

    }

    public static int[] solution(String[] S) {
        int[] arr = new int[3];
        boolean isDone = false;
        for (int i = 0; i < S.length - 1; i++) {
            String front = S[i];
            for (int j = i + 1; j < S.length; j++) {
                String rear = S[j];

                int len = front.length();
                for (int k = 0; k < len; k++) {
                    if (front.charAt(k) == rear.charAt(k)) {
                        arr[0] = i;
                        arr[1] = j;
                        arr[2] = k;

                        isDone = true;
                        break;
                    }
                }
                if (isDone) break;
            }
            if (isDone) break;
        }

        if (isDone) {
            return arr;
        } else {
            return new int[0];
        }

    }
}
