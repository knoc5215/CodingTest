package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String word = br.readLine();
        int len = word.length();

        int cnt = 0;
        for (int i = 0; i < document.length() - len + 1; i++) {
            String substring = document.substring(i, i + len);
            if (substring.equals(word)) {
                cnt++;
                i = i + len - 1;
            }
        }
        System.out.println(cnt);

    }
}
