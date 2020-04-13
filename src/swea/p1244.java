package swea;

import java.io.IOException;
import java.util.Scanner;


/*
    오른쪽 끝에서부터 1원이고 왼쪽으로 한자리씩 갈수록 10의 배수만큼 커진다.
    반드시 횟수만큼 교환이 이루어져야 하고 동일한 위치의 교환이 중복되어도 된다.

 */
public class p1244 {
    static int max;
    static String[] money;

    static int num, n;


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            num = sc.nextInt();
            n = sc.nextInt();

            money = String.valueOf(num).split("");

            max = 0;
            dfs(0, 0);

            System.out.println("#" + test_case + " " + max);


        }
    }

    public static void dfs(int current, int count) {
        if (count == n) {
            max = Math.max(max, stringToInt());
//            System.out.println("MAX = " + max);
            return;
        }

        for (int i = current; i < money.length; i++) {
            for (int j = i + 1; j < money.length; j++) {
                if (Integer.parseInt(money[i]) <= Integer.parseInt(money[j])) {
                    swap(i, j);
                    dfs(i, count + 1);
                    swap(i, j);
                }
            }
        }
    }

    public static int stringToInt() {
        StringBuilder sb = new StringBuilder();
        for (String str : money) {
            sb.append(str);
        }

        return Integer.parseInt(sb.toString());
    }

    public static void swap(int x, int y) {
        String temp = money[x];
        money[x] = money[y];
        money[y] = temp;
    }


}
