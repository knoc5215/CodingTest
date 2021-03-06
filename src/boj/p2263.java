package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2263 {
    static int[] inOrder, postOrder, pos;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        inOrder = new int[100000];
        postOrder = new int[100000];
        pos = new int[100001];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < n; i++) {
            pos[inOrder[i]] = i;    // inOrder 값들의 출현 순서
        }

        preOrder(0, n - 1, 0, n - 1);


    }

    private static void preOrder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return;
        }

        int pRoot = postOrder[pe];  // postOrder의 끝은 root
        System.out.print(pRoot + " ");  // root 먼저 출력해주고
        int iRoot = pos[pRoot]; // root의 출현 순서


        int left = iRoot - is;  // root의 출현 순서 왼쪽은 왼쪽 서브트리이다

        preOrder(is, iRoot - 1, ps, ps + left - 1); // 왼쪽 서브트리
        preOrder(iRoot + 1, ie, ps + left, pe - 1); // 오른쪽 서브트리

    }


}


