package codility.naverFinancial;

public class p2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 5, 9, 9};
        int X = 5;
        System.out.println(solution(A, 5));
//        System.out.println(binarySearch(A,9));
    }

    static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            if (A[m] == X) {
                return m;
            } else {
                if (A[m] > X) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }

    private static int binarySearch(int[] A, int n) {
        int first = 0;
        int last = A.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;

            if (n == A[mid])
                return 1;
            else {
                if (n < A[mid])
                    last = mid - 1;
                else
                    first = mid + 1;
            }
        }
        return 0;
    }
}
