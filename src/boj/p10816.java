package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p10816 {
    static int n, m;
    static int[] cards;
    public static final int UPPER = 10000000;
    public static final int MAX_ARR = UPPER * 2 + 1;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cards = new int[MAX_ARR];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int card = Integer.parseInt(st.nextToken());
            cards[card + UPPER]++;
        }
        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        while (st.hasMoreTokens()) {
            int have = Integer.parseInt(st.nextToken());
            stringBuilder.append(cards[have + UPPER] + " ");
        }

        System.out.println(stringBuilder.toString());


    }

}
