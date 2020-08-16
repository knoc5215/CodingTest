package programmers.heap;

import java.util.*;

public class DiskController {
    public static void main(String[] args) {
//        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        int[][] jobs = {{0, 3}, {1, 9}, {500, 6}};

        System.out.println(solution(jobs));
    }

    /*
        작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지
     */
    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1 == o2) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            nodeList.add(new Node(jobs[i][0], jobs[i][1]));
        }

        PriorityQueue<Node> waiting = new PriorityQueue<>();
        int prev_end = 0;
        int sum = 0;
        while (!nodeList.isEmpty() || !waiting.isEmpty()) {
            boolean isNew = false;

            Iterator<Node> itr = nodeList.iterator();
            while (itr.hasNext()) {
                Node node = itr.next();
                if (node.reqTime > prev_end) {
                    break;
                }

                waiting.add(node);
                itr.remove();
            }

            if (waiting.size() == 0) {
                waiting.add(nodeList.get(0));
                nodeList.remove(0);

                isNew = true;
            }

            Node waitingJob = waiting.poll();
            if (isNew) {
                sum += waitingJob.usedTime;
                prev_end = waitingJob.reqTime + waitingJob.usedTime;
            } else {
                sum += ((prev_end - waitingJob.reqTime) + waitingJob.usedTime);
                prev_end += waitingJob.usedTime;
            }
        }

        return sum / jobs.length;

    }

    static class Node implements Comparable<Node> {
        int reqTime;
        int usedTime;

        public Node(int reqTime, int usedTime) {
            this.reqTime = reqTime;
            this.usedTime = usedTime;
        }


        @Override
        public int compareTo(Node o) {
            return this.usedTime - o.usedTime;
        }
    }
}
