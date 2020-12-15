package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int repeat = Integer.parseInt(st.nextToken());
            String string = st.nextToken();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                sb.append(String.valueOf(ch).repeat(Math.max(0, repeat)));
            }

            System.out.println(sb);
        }

    }
}
