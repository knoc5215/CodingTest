package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class p2957 {
    static TreeMap<Integer, Integer> treeMap;
    static int N;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        treeMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if (i == 0) {
                treeMap.put(data, 0);
                ans = 0;
            } else {
                Integer upper = treeMap.higherKey(data);    // data보다 큰 값중 가장 작은 것 (바로 다음 값)
                Integer lower = treeMap.lowerKey(data);     // data보다 작은 값들 중 가장 큰 것 (바로 이전 값)

                int depth;
                if (upper == null) {
                    depth = treeMap.get(lower) + 1;
                    treeMap.put(data, depth);

                } else if (lower == null) {
                    depth = treeMap.get(upper) + 1;
                    treeMap.put(data, depth);

                } else {
                    int up = treeMap.get(upper);
                    int low = treeMap.get(lower);

                    depth = up > low ? up + 1 : low + 1;
                    treeMap.put(data, depth);
                }
                ans += depth;
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }


}
