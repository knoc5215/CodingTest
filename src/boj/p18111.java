package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p18111 {
    static int N, M, B;
    static int[][] arr;
    static int MIN_HEIGHT = Integer.MAX_VALUE;
    static int MAX_HEIGHT = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        B = stoi(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = stoi(st.nextToken());
                MIN_HEIGHT = Math.min(MIN_HEIGHT, arr[i][j]);
                MAX_HEIGHT = Math.max(MAX_HEIGHT, arr[i][j]);
            }
        }

        MAX_HEIGHT = Math.min(MAX_HEIGHT, 256); // 높이 최대 256

        List<Answer> list = new ArrayList<>();  // 같은 시간의 복수 정답건에 대한 list

        for (int height = MIN_HEIGHT; height <= MAX_HEIGHT; height++) {
            int time = 0;
            int inventory = B;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] != height) {  // 높이가 달라서 깎든/채우든 해야할 경우에만
                        if (arr[i][j] > height) {   // 깎아야 하는 경우
                            time += 2 * (arr[i][j] - height);   // 깎는데 2초 걸린다
                            inventory += arr[i][j] - height;    // 인벤토리에 깎은만큼 추가한다

                        } else {    // 채워야 하는 경우
                            int needs = Math.abs(arr[i][j] - height);   // 얼만큼 채워야하나
                            time += needs;  // 채우는데 1초 걸린다
                            inventory -= needs; // 인벤토리에서 채워준만큼 빼준다

                        }
                    }
                }
            }
            if (inventory >= 0) {   // 인벤토리가 0보다 작으면 말도 안되는 경우이니까 정답이 아니다
                list.add(new Answer(time, height));
            }

        }

        // 같은 시간의 정답이 여러개라면, 높이가 최대인 것을 출력하기 위해 정렬한다
        Collections.sort(list, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o2.height - o1.height;
            } else {
                return o1.time - o2.time;
            }
        });

        System.out.println(list.get(0).time + " " + list.get(0).height);


    }


    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    static class Answer {
        int time, height;

        public Answer(int time, int height) {
            this.time = time;
            this.height = height;
        }
    }


}
