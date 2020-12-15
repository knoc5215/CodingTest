package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Node node = new Node(i, sc.nextInt());
            list.add(node);
        }

        list.sort((o1, o2) -> o2.num - o1.num);

        System.out.println(list.get(0).getNum());
        System.out.println(list.get(0).getIndex() + 1);
    }

    static class Node {
        int index, num;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        public int getIndex() {
            return index;
        }

        public int getNum() {
            return num;
        }
    }
}
