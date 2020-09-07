package programmers.kakao_previous.blind_2019;

import java.util.ArrayList;
import java.util.List;

/*
실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 */
public class Fail {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] ans = solution(N, stages);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

    // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return
    // 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호
    // 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자
    public static int[] solution(int N, int[] stages) {
        List<Node> list = new ArrayList<>();

        int len = stages.length;

        for (int stage = 1; stage <= N; stage++) {
            int challenger = 0;
            int failer = 0;
            for (int i = 0; i < len; i++) {
                int curStage = stages[i];
                if (stage <= curStage) {
                    challenger++;
                    if (stage >= curStage) {
                        failer++;
                    }
                }
            }
            if (challenger == 0) {   // 스테이지에 도달한 유저가 없는 경우
                Node node = new Node(stage, 0.0);   // 스테이지 실패율은 0으로 정의한다.
                list.add(node);
            } else {
                double percentage = (double) failer / challenger;
//            System.out.println(stage + " 번 스테이지 실패율:" + failer + "/" + challenger);
                Node node = new Node(stage, percentage);
                list.add(node);
            }
        }

        list.sort((o1, o2) -> {
            if (o1.percent == o2.percent) {
                return (int) (o2.percent - o1.percent);
            } else {
                return -Double.compare(o1.percent, o2.percent);  // 주의할것
            }
        });

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
            answer[i] = list.get(i).stage;
        }


        return answer;
    }

    static class Node {
        int stage;
        double percent;

        public Node(int stage, double percent) {
            this.stage = stage;
            this.percent = percent;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "stage=" + stage +
                    ", percent=" + percent +
                    '}';
        }
    }
}
