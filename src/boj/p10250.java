package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10250 {
    public static int H, W, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int seq = 0;

            int h = 1;
            int w = 1;
            while (seq < N) {
                StringBuilder host = new StringBuilder();
                if (h > H) {
                    h = 1;
                    w++;
                }
                host.append(h++).append(getNumber(w));
                seq++;
                if (seq == N) {
                    System.out.println(host);
                    break;
                }
            }
        }
    }

    public static String getNumber(int number) {
        if (String.valueOf(number).length() < 2) {
            return "0" + number;
        } else {
            return "" + number;
        }
    }


}
