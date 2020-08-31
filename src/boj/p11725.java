package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p11725 {
    static ArrayList<Integer>[] arrayLists;
    static int N;
    static int[] arr;
    static boolean[] visit;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arrayLists = new ArrayList[N + 1];


        arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
            arr[i] = i; // 자기자신으로 초기화
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }

//        BFS();
        visit = new boolean[N + 1];
        visit[1] = true;
        DFS(1);


        for (int i = 2; i < N + 1; i++) {
            System.out.println(arr[i]);
        }


    }

    static void DFS(int start) {
        ArrayList<Integer> arrayList = arrayLists[start];
        for (int i = 0; i < arrayList.size(); i++) {
            int next = arrayList.get(i);
            if (!visit[next]) {
                visit[next] = true;
                arr[next] = start;
                DFS(next);
            }
        }
    }

    static void BFS() {
        visit = new boolean[N + 1];

        queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < arrayLists[cur].size(); i++) {
                int next = arrayLists[cur].get(i);
                if (!visit[next]) {
                    visit[next] = true;
                    arr[next] = cur;
                    queue.add(next);
                }
            }
        }
    }


}
