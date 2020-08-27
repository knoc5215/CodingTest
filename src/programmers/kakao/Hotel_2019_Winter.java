package programmers.kakao;

import java.util.*;

public class Hotel_2019_Winter {
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {
        long k = 10;    // 전체 방 갯수
        long[] room_number = {1, 3, 4, 1, 3, 1};

        long[] answer = solution(k, room_number);
        for (long val : answer) {
            System.out.print(val + " ");
        }
    }

    //각 고객에게 배정되는 방 번호를 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
    public static long[] solution(long k, long[] room_number) {
        int size = room_number.length;

        long[] answer = new long[size];
        for (int i = 0; i < size; i++) {
//          answer[i] = findEmptyRoom(room_number[i]);

            answer[i] = find(room_number[i]);
            union(room_number[i]);
        }

        return answer;
    }

    public static long findEmptyRoom(long room_number) {
        if (!map.containsKey(room_number)) {
            map.put(room_number, room_number + 1);
            return room_number;
        }
        long nextRoom = map.get(room_number);
        long emptyRoom = findEmptyRoom(nextRoom);
        map.put(room_number, emptyRoom);

        return emptyRoom;
    }

    public static void union(long x) {
        x = find(x);
        map.put(x, x + 1);
    }

    public static long find(long x) {
        if (!map.containsKey(x)) {
            return x;
        }

        long parent = find(map.get(x));
        map.put(x, parent);
        return parent;
    }


}
