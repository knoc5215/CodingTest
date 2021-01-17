package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p16953 {
    public static long a, b;
    public static boolean isDone = false;
    public static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        solve(a, 0);

        System.out.println(isDone ? ret + 1 : -1);
    }

    static void solve(long from, int count) {
        if (from == b) {
            isDone = true;
            ret = count;
        } else if (from < b) {
            solve(from * 2, count + 1);
            solve(Long.parseLong(from + "1"), count + 1);
        }
    }
}
