package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        int b = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        st = new StringTokenizer(br.readLine());
        Set<Integer> setA = new HashSet<>();
        while (st.hasMoreTokens()) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        a = setA.size();

        st = new StringTokenizer(br.readLine());
        Set<Integer> setB = new HashSet<>();
        while (st.hasMoreTokens()) {
            int cur = Integer.parseInt(st.nextToken());
            if (!setA.contains(cur)) {
                b++;    // B-A 차집합 카운팅
            } else {
                setB.add(cur);
            }
        }

        a -= setB.size();   // A-B 차집합 카운팅
        System.out.println(a + b);  // 대칭 차집합 계산


    }
}
