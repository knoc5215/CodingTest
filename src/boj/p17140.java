package boj;

import java.util.*;

public class p17140 {
    private static int[][] arr = new int[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        while (true) {

            if (time > 100) {
                time = -1;
                break;
            }

            if (r - 1 < arr.length && c - 1 < arr[0].length) {
                if (arr[r - 1][c - 1] == k) {
                    break;
                }
            }
            int rn = arr.length;
            int cn = arr[0].length;

            if (rn >= cn) {
                opcodeR();
            } else {
                opcodeC();
            }

            time++;


        }

        System.out.println(time);

    }

    public static void opcodeR() {
        Node[] nodes;
        int rows = arr.length;
        int cols = arr[0].length;

        ArrayList[] lists = initArrayLists(rows);

        for (int i = 0; i < rows; i++) {
            nodes = initCounter();
            for (int j = 0; j < cols; j++) {
                int val = arr[i][j];
                if (val > 0) {
                    nodes[val].cnt++;
                }
            }
            for (int j = 1; j <= 100; j++) {
                Node node = nodes[j];
                if (node.cnt > 0) {
                    lists[i].add(node);
                }
            }
        }

        for (int i = 0; i < lists.length; i++) {
            ArrayList<Node> nodeList = lists[i];
            Collections.sort(nodeList);
        }
        arr = listToArray(lists);
    }

    public static void opcodeC() {
        int[][] rotate = rotateRight(arr);

        Node[] nodes;
        int rows = rotate.length;
        int cols = rotate[0].length;

        ArrayList[] lists = initArrayLists(rows);

        for (int i = 0; i < rows; i++) {
            nodes = initCounter();
            for (int j = 0; j < cols; j++) {
                int val = rotate[i][j];
                if (val > 0) {
                    nodes[val].cnt++;
                }
            }
            for (int j = 1; j <= 100; j++) {
                Node node = nodes[j];
                if (node.cnt > 0) {
                    lists[i].add(node);
                }
            }
        }

        for (int i = 0; i < lists.length; i++) {
            ArrayList<Node> nodeList = lists[i];
            Collections.sort(nodeList);
        }

        rotate = listToArray(lists);
        arr = rotateLeft(rotate);

    }

    public static int[][] rotateRight(int[][] arr) {
        int[][] rotate = new int[arr[0].length][arr.length];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                rotate[j][i] = arr[i][j];
            }
        }


        return rotate;
    }

    public static int[][] rotateLeft(int[][] arr) {
        int[][] rotate = new int[arr[0].length][arr.length];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                rotate[j][i] = arr[i][j];
            }
        }


        return rotate;
    }

    public static int[][] listToArray(ArrayList<Node>[] lists) {

        int maxCol = 0;

        ArrayList[] tempList = new ArrayList[lists.length];
        for (int i = 0; i < tempList.length; i++) {
            tempList[i] = new ArrayList();
        }

        for (int i = 0; i < lists.length; i++) {
            ArrayList<Node> row = lists[i];
            for (int j = 0; j < row.size(); j++) {
                Node node = row.get(j);

                tempList[i].add(node.val);
                tempList[i].add(node.cnt);

            }
            maxCol = maxCol < tempList[i].size() ? tempList[i].size() : maxCol;
        }

        int[][] toArray = new int[lists.length][maxCol];
        for (int i = 0; i < tempList.length; i++) {
            Arrays.fill(toArray[i], 0);
            for (int j = 0; j < tempList[i].size(); j++) {
                toArray[i][j] = (int) tempList[i].get(j);
            }
        }

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].size() < maxCol) {
                int cnt = maxCol - tempList[i].size();
                for (int j = 0; j < cnt; j++) {
                    tempList[i].add(0);
                }
            }
        }
        return toArray;

    }


    public static ArrayList<Node>[] initArrayLists(int rows) {
        ArrayList[] lists = new ArrayList[rows];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
        }
        return lists;
    }

    public static Node[] initCounter() {
        Node[] nodes = new Node[101];
        for (int i = 1; i <= 100; i++) {
            nodes[i] = new Node(i, 0);
        }

        return nodes;
    }

    static class Node implements Comparable<Node> {
        int val, cnt;

        public Node(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt < o.cnt) {
                return -1;
            } else if (this.cnt > o.cnt) {
                return 1;
            } else {
                if (this.val < o.val) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

}
