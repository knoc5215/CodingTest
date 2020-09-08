package programmers.kakao_previous.blind_2018;

import java.util.*;

public class Bus_1st {
    public static void main(String[] args) {
        String[] timeTable = {"08:00", "08:01", "08:02", "08:03"};
        int n = 1;
        int t = 1;
        int m = 5;

        String ans = solution(n, t, m, timeTable);
        System.out.println(ans);
    }

    /*
    콘이 셔틀을 타고 사무실로 갈 수 있는 도착 시각 중 제일 늦은 시각을 구하여라.
    콘은 게으르기 때문에 같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다.
    또한, 모든 크루는 잠을 자야 하므로 23:59에 집에 돌아간다. 따라서 어떤 크루도 다음날 셔틀을 타는 일은 없다.
     */
    public static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> crew = new PriorityQueue<>(Comparator.comparingInt(o -> o)); //오름차순 정렬
        for (String time : timetable) {
            int hh = Integer.parseInt(time.substring(0, 2)) * 60;
            int mm = Integer.parseInt(time.substring(3));
            crew.offer(hh + mm);
        }

        int bus = 9 * 60;   // 분단위로 초기화
        int lastAcceptTime = 0;

        while (n-- > 0) {
            int accept = m; // 수용인원
            int time = 0;  // 마지막 탑승 시간
            while (!crew.isEmpty()) {   // 기다리는 크루가 있다면
                int front = crew.peek();
                if (front <= bus && accept > 0) {   // 버스보다 빨리왔고 && 수용가능하면
                    accept--;
                    time = front; // 마지막 탑승 시간 갱신
                    crew.poll();
                } else {
                    break;
                }

            }

            if (n > 0) {    // 아직 마지막 버스가 아니라면
                if (crew.isEmpty()) {   // 기다리는 크루가 없다면
                    lastAcceptTime = bus + ((n + 1) * t);   // 마지막 버스 시간 갱신
                    break;
                }
                bus += t;    // 버스의 다음시간 갱신
            } else {    // 마지막 버스라면
                if (accept > 0) {   // 아직 탑승할 수 있으면
                    lastAcceptTime = bus;   // 버스도착시간에 마지막으로 탑승했다
                } else {
                    lastAcceptTime = time - 1;  // 1분 더 빨리와서 타야함 그래야 탑승가능
                    break;
                }
            }

        }


        String answer = String.format("%02d", lastAcceptTime / 60) + ":" + String.format("%02d", lastAcceptTime % 60);
        return answer;
    }

    // HH:MM --> HHMM int (0000 ~ 2359)
    public static int stoi(String time) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(time, ":");
        while (st.hasMoreTokens()) {
            sb.append(st.nextToken());
        }

        System.out.println("parse from " + time + " to " + sb);

        return Integer.parseInt(sb.toString());
    }
}
