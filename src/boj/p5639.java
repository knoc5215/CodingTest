package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p5639 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        int data;
        Node root = null;
        while ((str = br.readLine()) != null && str.length() != 0) {
            try {
                data = Integer.parseInt(str);
                root = insert(root, data);
            } catch (Exception e) {
                break;
            }
        }

        postOrder(root);
    }

    static void postOrder(Node node) {
        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        System.out.println(node.data);

    }

    static Node insert(Node node, int data) {
        Node curNode = null;

        if (node == null) {
            return new Node(data);
        }

        if (node.data > data) {
            curNode = insert(node.left, data);
            node.left = curNode;
        } else if (node.data < data) {
            curNode = insert(node.right, data);
            node.right = curNode;
        }

        return node;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }


}
