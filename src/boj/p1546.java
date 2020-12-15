package boj;

import java.util.Scanner;

public class p1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] scores = new double[n];

        double max = -1;
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            max = Math.max(max, scores[i]);
        }

        double sum = 0;
        for (int i = 0; i < n; i++) {
            scores[i] = (scores[i] / max) * 100.0;
            sum += scores[i];
        }
        System.out.println(sum / (double) n);
    }
}
