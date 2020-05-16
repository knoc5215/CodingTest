package boj;

import java.util.*;

/*
    N번째 큰 수
    모든 수는 자신의 한 칸 위에 있는 수보다 크다는 것이다.
 */
public class p2075 {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < N; i++) {
            List<Integer> row = arrayToList(arr[i]);
            pq.addAll(row);
            for (int j = 0; j < N-1; j++) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());


    }

    static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int val : arr) {
            list.add(val);
        }

        return list;
    }
}
