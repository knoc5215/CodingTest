package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p11652 {
    public static void main(String[] args) throws IOException {
        Map<Long, Integer> map = new HashMap<>();
        int maxCnt = Integer.MIN_VALUE;
        long maxVal = Long.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            long val = Long.parseLong(br.readLine());
            int cnt = map.getOrDefault(val, 0) + 1;

            if (maxCnt < cnt) {
                maxCnt = cnt;
                maxVal = val;
            } else if (maxCnt == cnt && maxVal > val) {
                maxVal = val;
            }
            map.put(val, cnt);
        }
        System.out.println(maxVal);
    }
}
