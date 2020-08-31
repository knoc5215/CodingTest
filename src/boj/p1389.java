package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1389 {
    static int N, M;
    static ArrayList<Integer>[] arrayLists;
    static int[] ans;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[N + 1];

        arrayLists = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayLists[a].add(b);
            arrayLists[b].add(a);
        }


        for (int i = 1; i < N + 1; i++) {
            visit = new boolean[N + 1];
            visit[i] = true;

            dist = new int[N + 1];  // i부터 각 vertex까지의 최소단계를 저장하는 배열
            DFS(i, 0);

            ans[i] = getKevin_Bacon();
        }
        System.out.println(getMinKevinBaconIdx());
    }

    static int getKevin_Bacon() {
        int sum = 0;
        for (int val : dist) {
            sum += val;
        }
        return sum;
    }

    static void DFS(int start, int depth) {
        if (dist[start] != 0) { //처음지나온게 아니라면 (1-3-4일때는 2, 1-4일때는 1이니까)
            dist[start] = Math.min(dist[start], depth); //더 작은 값을 넣어준다
        } else {    //첫방문일때 초기화
            dist[start] = depth;
        }

        for (int i = 0; i < arrayLists[start].size(); i++) {
            int next = arrayLists[start].get(i);
            if (!visit[next]) {
                visit[next] = true;
                DFS(next, depth + 1);
                visit[next] = false;    //backtracking
            }
        }
    }

    static int getMinKevinBaconIdx() {
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < N + 1; i++) {
            if (ans[i] < min) {
                idx = i;
                min = ans[i];
            }
        }

        return idx;
    }
}
