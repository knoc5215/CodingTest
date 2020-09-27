package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class p1620 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, String> integerMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            String name = stringTokenizer.nextToken();
            if (!stringMap.containsKey(name)) {
                stringMap.put(name, i + 1);
                if (!integerMap.containsKey(i + 1)) {
                    integerMap.put(i + 1, name);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            String str = stringTokenizer.nextToken();
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                System.out.println(integerMap.get(Integer.parseInt(str)));
            } else {
                System.out.println(stringMap.get(str));
            }
        }
    }
}
