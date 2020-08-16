package programmers.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RamenFactory {
    public static void main(String[] args) {

    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int supplyIdx = 0;
        int day = 0;
        while (day < k) {
            if (supplyIdx < dates.length && day == dates[supplyIdx]) {
                priorityQueue.add(supplies[supplyIdx++]);
            }

            stock--;

            if (stock == -1) {
                stock += priorityQueue.poll();
                answer++;
            }

            day++;


        }

        return answer;
    }
}
