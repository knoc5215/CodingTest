package Kakao_Blind_2020;

/*
같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현
aabbaccc의 경우 2a2ba3c(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)
 */
public class Solution_01 {
    public static void main(String[] args) {
        /*String[] arr = new String[]{"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd"};
        for (String str : arr) {
            System.out.println(solution(str));
        }*/

        System.out.println(solution2(11));
    }

    public static int solution(String s) {
        String origin = s;
        String buffer = "";
        String resultStr = "";

        int bufferCount = 1;
        int resultLen = origin.length();
        int resultCount = resultLen;

        System.out.println("\t\t\t\t\t\t ORIGIN is " + s);

        for (int slice = 1; slice <= origin.length() / 2; slice++) {
            for (int i = 1; i <= origin.length() / slice; i++) {
                if (buffer.equals(origin.substring((i - 1) * slice, i * slice))) {
                    bufferCount++;
                } else {
                    if (bufferCount != 1) {
                        resultStr += Integer.toString(bufferCount);
                        bufferCount = 1;
                    }
                    resultStr += origin.substring((i - 1) * slice, i * slice);
                }
                buffer = origin.substring((i - 1) * slice, i * slice);
            }

            if (bufferCount != 1) {
                resultStr += Integer.toString(bufferCount);
                bufferCount = 1;
            }

            if (resultLen % slice != 0) {
                resultStr += origin.substring(resultLen - resultLen % slice, resultLen);
            }

            if (resultStr.length() < resultCount) {
                resultCount = resultStr.length();
            }
            System.out.println("slice = " + slice + ", \t resultStr = " + resultStr);

            resultStr = "";

        }


        return resultCount;
    }

    public static int solution2(String s) {
        String exStr = s;
        String bufStr = "";
        String resultStr = "";
        int bufCount = 1;
        int resultLen = exStr.length();
        int resultCount = resultLen;

        for (int i = 1; i <= exStr.length() / 2; i++) {
            for (int j = 1; j <= exStr.length() / i; j++) {
                if (bufStr.equals(exStr.substring((j - 1) * i, j * i))) {
                    bufCount++;
                } else {
                    if (bufCount != 1) {
                        resultStr += Integer.toString(bufCount);
                        bufCount = 1;
                    }
                    resultStr += exStr.substring((j - 1) * i, j * i);
                }
                bufStr = exStr.substring((j - 1) * i, j * i);
            }
            if (bufCount != 1) {
                resultStr += Integer.toString(bufCount);
                bufCount = 1;
            }
            if (resultLen % i != 0)
                resultStr += exStr.substring(resultLen - resultLen % i, resultLen);
            if (resultStr.length() < resultCount) {
                resultCount = resultStr.length();
            }
            resultStr = "";
        }
        System.out.println(resultCount);
        return resultCount;
    }

    public static int solution(int n) {

        long num = (long)n;
        for (int i = 0; i < 500; i++) {
            if (num == 1) {
                return i;
            }
            num = (num % 2 == 0) ? num / 2 : num * 3 + 1;
        }

        return -1;
    }

    public static boolean solution2(int x) {


        int sum = 0;
        String str = Integer.toString(x);
        for(int i=0; i<str.length(); i++) {
            char cur = str.charAt(i);
            String curS = Character.toString(cur);
            int curI = Integer.parseInt(curS);

            sum += curI;
        }

        System.out.println("sum : " + sum);

        if(x % sum == 0) {
            return true;
        }
        else {
            return false;
        }




    }

}


