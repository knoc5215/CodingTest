package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class p2751 {
    static int n;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(stoi(br.readLine()));
        }
        br.close();

        Collections.sort(list);

        StringBuilder stringBuilder = new StringBuilder();
        for (int val : list) {
            stringBuilder.append(val).append('\n');
        }

        System.out.println(stringBuilder);


    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
