package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1110 {
    public static String START;

    /**
     * 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고
     * 각 자리의 숫자를 더한다.
     * 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        START = str;
        String inputRight;
        int cycle = 0;

        while (true) {
            inputRight = str.charAt(str.length() - 1) + ""; // 주어진 수의 가장 오른쪽 자리 수
            if (str.length() == 1) {    // 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고
                str += "0";
            }
            int sum = getSum(str);  // 각 자리의 숫자를 더한다
            String sumRight = String.valueOf(sum).charAt(String.valueOf(sum).length() - 1) + "";    // 앞에서 구한 합의 가장 오른쪽 자리 수
            str = Integer.parseInt(inputRight + sumRight) + "";    // 이어 붙이면 새로운 수를 만들 수 있다

            cycle++;
            if (START.equals(str)) {
                System.out.println(cycle);
                return;
            }
        }
    }

    static int getSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sum += Integer.parseInt(ch + "");
        }
        return sum;
    }
}
