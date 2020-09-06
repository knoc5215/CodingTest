package programmers.kakao_previous.blind_2019;

import java.util.*;

/*
무지의 먹방 라이브
네트워크 정상화 후 다시 방송을 이어갈 때
몇 번 음식부터 섭취해야 하는지를 알고자 한다.
 */
public class EatingLive {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(solution(food_times, k));
    }

    public static int solution(int[] food_times, long k) {
        List<Food> list = new LinkedList<>();

        for (int i = 0; i < food_times.length; i++) {
            list.add(new Food(i+1, food_times[i]));
        }

        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.remain - o2.remain;
            }
        });

        Iterator<Food> itr = list.iterator();
        int prev = 0;
        while (itr.hasNext()) {
            int time = itr.next().remain;
            long minus = time - prev;
            if (minus != 0) {
                long diff = minus * list.size();
                if (diff > k) {
                    break;
                }
                k -= diff;
                prev = time;
            }
            itr.remove();
        }

        if (list.size() == 0) {
            return -1;
        }

        k %= (long) list.size();
        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.index - o2.index;
            }
        });

        return list.get((int) k).index;


    }

    static class Food {
        int index, remain;

        public Food(int index, int remain) {
            this.index = index;
            this.remain = remain;
        }


    }
}
