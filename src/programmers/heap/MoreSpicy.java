package programmers.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)

Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 */
public class MoreSpicy {

    public static void main(String[] args) {
        int[] scoville = {1, 3, 8, 14};
        int k = 7;

        int ret = solution(scoville, k);
        System.out.println(ret);
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val : scoville) {
            priorityQueue.add(val);
        }
        int mix = priorityQueue.peek();

        while (priorityQueue.peek() < K && priorityQueue.size() > 1) {

            Object[] arr = priorityQueue.toArray();
            for (Object obj : arr) {
                System.out.print(obj + " ");
            }
            System.out.println();


            int first = priorityQueue.remove();
            int next = priorityQueue.remove();
            System.out.println("first=" + first + ", next=" + next);
            mix = first + next * 2;
            priorityQueue.add(mix);
            answer++;

            System.out.println("mix=" + mix + ", turn=" + answer);

        }
        if (priorityQueue.peek() < K) {
            return -1;
        } else {
            return answer;
        }
    }
}
