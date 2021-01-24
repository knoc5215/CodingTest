package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p18119 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        boolean[][] words = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                words[i][ch - 'a'] = true;  // i번 단어의 j번째 알파벳이 사용된다 체크
            }
        }

        boolean[] valid = new boolean[n];   // 단어마다 모든 알파벳을 기억한 상태이다
        Arrays.fill(valid, true);

        int[] counts = new int[n];  // 각 단어마다 잊어버린 알파벳 개수
        int ans = n;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int method = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);

            if (method == 1) {  // 잊어버릴때
                for (int j = 0; j < n; j++) {   // 단어마다 돌면서
                    if (words[j][ch - 'a']) {   // 해당 단어의 ch가 존재한다면
                        counts[j]++;    // 잊어버리기 카운트 1 증가

                        if (valid[j]) { // 그런데 모든 알파벳을 알고 있는 상태라면
                            valid[j] = false;   // 잊어버리기 카운트가 증가했으니까 false로 바꿔주고
                            ans--;  // 모든 알파벳을 알지 못하는 상태니까 ans -1
                        }
                    }
                }
            } else {    // 기억해낼때
                for (int j = 0; j < n; j++) {
                    if (!valid[j] && words[j][ch - 'a']) {  // 모든 알파벳을 모르는 상태면서 && 해당 ch 가 단어에 속한다면
                        counts[j]--;    // 잊어버리는거 1 감소

                        if (counts[j] == 0) {   // 잊어버린게 없다는 것은 해당 단어의 모든 알파벳을 알고 있다는 것이니까
                            valid[j] = true;    // true 해주고
                            ans++;  // 모든 알파벳을 알고 있다니까 ans + 1
                        }
                    }
                }
            }

            System.out.println(ans);
        }


    }


}
