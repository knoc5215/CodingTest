package programmers.statc_queue;

public class StockPrice {
    public static void main(String[] args) {
        int[] ret = solution(new int[]{1, 2, 3, 2, 3});
        for (int val : ret) {
            System.out.print(val + " ");
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                time++;
                if (price > prices[j]) {
                    break;
                }
            }
            answer[i] = time;
        }

        return answer;
    }
}
