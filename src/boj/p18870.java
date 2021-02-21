package boj;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] origin = new int[n];
        if (n >= 0) System.arraycopy(arr, 0, origin, 0, n);

        Arrays.sort(arr);
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (!map.containsKey(num)) {
                map.put(num, counter++);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int val : origin) {
            bw.write(map.get(val) + " ");
        }

        bw.flush();
        bw.close();


    }
}
