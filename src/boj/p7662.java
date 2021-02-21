package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class p7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = Integer.parseInt(stringTokenizer.nextToken());
        while (testCase-- > 0) {
            TreeMap<Long, Long> treeMap = new TreeMap<>();

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String method = stringTokenizer.nextToken();
                Long key = Long.parseLong(stringTokenizer.nextToken());

                if ("I".equals(method)) {
                    if (treeMap.containsKey(key)) {
                        treeMap.put(key, treeMap.get(key) + 1);
                    } else {
                        treeMap.put(key, 1L);
                    }
                } else {
                    if (treeMap.isEmpty()) {
                        continue;
                    }
                    if (key == 1) { // remove max
                        long maxKey = treeMap.lastKey();
                        long count = treeMap.get(maxKey);
                        if (count > 1) {
                            treeMap.put(maxKey, count - 1);
                        } else {
                            treeMap.remove(maxKey);
                        }


                    } else {    // remove min
                        long minKey = treeMap.firstKey();
                        long count = treeMap.get(minKey);
                        if (count > 1) {
                            treeMap.put(minKey, count - 1);
                        } else {
                            treeMap.remove(minKey);
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                long max = treeMap.lastKey();
                long min = treeMap.firstKey();

                System.out.println(max + " " + min);
            }

        }


    }
}
