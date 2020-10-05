package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class p11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if ("all".equals(cmd)) {
                for (int i = 1; i <= 20; i++) {
                    if (!set.contains(i)) set.add(i);
                }
            } else if ("empty".equals(cmd)) {
                set.clear();
            } else {
                int x = Integer.parseInt(st.nextToken());

                if ("add".equals(cmd)) {
                    set.add(x);
                } else if ("remove".equals(cmd)) {
                    set.remove(x);
                } else if ("check".equals(cmd)) {
                    stringBuilder.append(set.contains(x) ? 1 : 0).append("\n");
                } else if ("toggle".equals(cmd)) {
                    if (set.contains(x)) set.remove(x);
                    else set.add(x);
                }
            }
        }

        System.out.println(stringBuilder.toString());

    }
}
