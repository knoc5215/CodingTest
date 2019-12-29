package kakao;

import java.util.*;

public class p4 {

    public static void main(String[] args) {
        long k = 10;
        long[] arr = {1, 3, 4, 1, 3, 1};

        long[] ret = solution(k, arr);
        for (long val : ret) {
            System.out.print(val + " ");
        }
    }

    public static long[] solution(long k, long[] room_number) {


        List<Long> list = new ArrayList<>();

        long max = Integer.MIN_VALUE;
        for (long val : room_number) {
            max = Math.max(max, val);
        }

        Set<Long> set = new HashSet<>();
        int counter = 0;
        for (int i = 0; i < room_number.length; i++) {
            if (!set.contains(room_number[i])) {
                set.add(room_number[i]);
            } else {
                counter++;
            }
        }

        long end = max + counter;


        for (int i = 0; i < room_number.length; i++) {
            long wantRoomNum = room_number[i];
            max = Math.max(max, wantRoomNum);

            System.out.println("current is " + wantRoomNum);
            if (!list.contains(wantRoomNum)) {
//                set.add(wantRoomNum);
                list.add(wantRoomNum);
                System.out.println("ADDED " + wantRoomNum);
            } else {


                for (long idx = wantRoomNum + 1; idx <= end; idx++) {
                    if (!list.contains(idx)) {
//                        set.add(idx);
                        list.add(idx);
                        System.out.println("SUB ADDED " + idx);
                        break;
                    }

                }
            }

        }
        long[] answer = new long[list.size()];
        int index = 0;
        for (Long val : list) {
            if (val > 0) {
                answer[index++] = val;
            }
        }


        return answer;
    }
}
