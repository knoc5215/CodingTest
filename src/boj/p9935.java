package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p9935 {
    static String str;
    static String exploding;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        exploding = br.readLine();

        int idx = 0;
        int len;
        char[] ans = new char[1000001];
        char[] bomb = new char[37];
        for (int i = 0; i < exploding.length(); i++) {
            bomb[i] = exploding.charAt(i);
        }
        len = exploding.length();

        for (int i = 0; i < str.length(); i++) {
            ans[idx++] = str.charAt(i);
            if (ans[idx - 1] == bomb[len - 1]) {    // 탐색중인 위치가 == 폭발문자열의 끝글자와 같다면
                if (idx < len) continue;    // 43cavcxvx , 폭발은 C4 일때 --> idx = 0 = 문자4 일때 4, len - 1 = 1 = 문자4
                boolean flag = false;
                for (int j = 0; j < len; j++) {
                    if (ans[idx - 1 - j] != bomb[len - 1 - j]) {    // 역으로 탐색하면서, 다르다면 break
                        flag = true;
                        break;
                    }
                }

                if (!flag) {    // 폭발문자열을 발견했다면
                    idx -= len; // 현재 idx에서 len을 뺀다 -> 폭발문자열 포인터만큼 제거
                }

            }
        }

        if (idx == 0) System.out.println("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idx; i++) {
                sb.append(ans[i]);
            }
            System.out.println(sb);
        }


    }
}
