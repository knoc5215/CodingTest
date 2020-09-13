package programmers.kakao_previous.blind_2020;

import java.util.Arrays;
import java.util.LinkedList;

/*
레스토랑의 구조는 완전히 동그란 모양이고 외벽의 총 둘레는 n미터
취약한 지점들 점검 시간을 1시간으로 제한
레스토랑의 정북 방향 지점을 0으로 나타내며, 취약 지점의 위치는 정북 방향 지점으로부터 시계 방향으로 떨어진 거리로 나타냅니다.
친구들은 출발 지점부터 시계, 혹은 반시계 방향으로 외벽을 따라서만 이동합니다.
취약 지점을 점검하기 위해 보내야 하는 친구 수의 최소값을 return 하도록 solution 함수를 완성해주세요.
 */
public class ExteriorWallInspection {
    static int n;
    static boolean[] visit;
    static int[] weakPoint;
    static int[][] rotateWeak;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int n = 12;
        int[] weak = {1, 5, 6, 10};
        weakPoint = weak.clone();
        int[] dist = {1, 2, 3, 4};

        int answer = solution(n, weak, dist);
        System.out.println(answer);

    }

    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        weakPoint = weak.clone();
        Arrays.sort(dist);
        visit = new boolean[dist.length];
        rotateWeak = new int[weak.length][weak.length];
        setWeak();


        int count = 0;
        LinkedList<Integer> list = new LinkedList<>();

        permutation(count, list, dist);

        answer = min;


        return answer;
    }

    static void setWeak() {
        int len = weakPoint.length;
        for (int i = 0; i < len; i++) {
            rotateWeak[i] = rotate(weakPoint, i);
        }
    }

    static int[] rotate(int[] weak, int idx) {
        int len = weak.length;
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            if (i + idx < len) {
                arr[i] = weak[i + idx];
            } else {
                arr[i] = weak[i + idx - len] + n;
            }
        }

        return arr;
    }

    static void run(LinkedList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < rotateWeak.length; i++) {
            int idx = 0;
            int start = rotateWeak[i][idx];

            for (int j = 0; j < len; j++) {
                while (idx < rotateWeak.length && rotateWeak[i][idx] - start <= list.get(j)) {
                    idx++;
                }

                if (idx >= rotateWeak.length) {
                    min = Math.min(min, len);
                } else {
                    start = rotateWeak[i][idx];
                }

            }
        }
    }


    static void permutation(int cnt, LinkedList<Integer> list, int[] dist) {
        if (cnt == dist.length) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
            run(list);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                list.add(dist[i]);
                permutation(cnt + 1, list, dist);

                list.removeLast();
                visit[i] = false;
            }
        }

    }

}
