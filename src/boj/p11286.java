package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class p11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.abs != o2.abs) {
                return o1.abs - o2.abs;
            } else {
                return o1.number - o2.number;
            }

        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            Node node = new Node(num, Math.abs(num));

            if (num != 0) {  // add
                priorityQueue.add(node);

            } else {  // remove abs min
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll().number);
                }
            }
        }
    }

    static class Node {
        int number;
        int abs;

        public Node(int number, int abs) {
            this.number = number;
            this.abs = abs;
        }
    }
}
