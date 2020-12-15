package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            String str = br.readLine();

            int point = 1;
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                String cur = str.charAt(i) + "";
                if ("O".equals(cur)) {
                    sum += point++;
                } else {
                    point = 1;
                }

            }

            System.out.println(sum);
        }

    }
}
