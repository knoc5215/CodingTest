package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성
알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.

 */
public class p1759 {
    static int L, C;
    static char[] chars;
    static boolean[] visit;
    static Set<Character> set;
    static Set<String> pwSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);

        set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        Arrays.sort(chars);
        for (int i = 0; i < C; i++) {
            visit = new boolean[C];
            visit[i] = true;
            DFS(1, i);
        }

        String[] ans = new String[pwSet.size()];
        pwSet.toArray(ans);
        Arrays.sort(ans);
        for (String password : ans) {
            System.out.println(password);
        }


    }


    static void DFS(int depth, int from) {
        if (depth == L) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if (visit[i])
                    sb.append(chars[i]);
            }

            if (isContains(sb) && isIncreasingly(sb)) {
                pwSet.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < C; i++) {
            if (!visit[i] && chars[from] < chars[i]) {
                visit[i] = true;
                char next = chars[i];
                DFS(depth + 1, i);
                visit[i] = false;
            }
        }
    }

    static boolean isContains(StringBuilder sb) {
        int ja = 0;
        int mo = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (set.contains(sb.charAt(i)))
                mo++;
        }

        ja = sb.length() - mo;

        return ja >= 2 && mo >= 1;

    }

    static boolean isIncreasingly(StringBuilder sb) {
        char[] chArr = sb.toString().toCharArray();
        for (int i = 0; i < L - 1; i++) {
            if (chArr[i] > chArr[i + 1])
                return false;
        }
        return true;
    }
}
