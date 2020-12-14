package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int input;
        long sum = 0;
        List<Integer> prevList = new ArrayList<>();
        while (K-- > 0) {
            input = Integer.parseInt(br.readLine());
            if (input != 0) {
                sum += input;
                prevList.add(input);
            } else {
                sum -= prevList.remove(prevList.size() - 1);
            }
        }
        System.out.println(sum);


    }
}
