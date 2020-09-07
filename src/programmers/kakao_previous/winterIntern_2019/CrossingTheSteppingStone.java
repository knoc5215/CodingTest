package programmers.kakao_previous.winterIntern_2019;

/*
징검다리 건너기
 */
public class CrossingTheSteppingStone {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));

    }

    /*
    디딤돌에 적힌 숫자가 순서대로 담긴 배열 stones와 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k가 매개변수로 주어질 때,
    최대 몇 명까지 징검다리를 건널 수 있는지 return 하도록 solution 함수를 완성해주세요.
     */
    public static int solution(int[] stones, int k) {
        int person = 0;

        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid, stones, k)) {
                person = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return person;
    }

    static boolean isPossible(int mid, int[] stones, int k) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] <= (mid - 1)) {
                count++;
            } else {
                count = 0;
            }

            if (k <= count) {
                return false;
            }
        }
        return true;
    }


}
