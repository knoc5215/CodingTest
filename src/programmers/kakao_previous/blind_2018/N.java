package programmers.kakao_previous.blind_2018;

import org.junit.Assert;
import org.junit.Test;

public class N {
    public static void main(String[] args) {

    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder("");
        StringBuilder binary = new StringBuilder("0");  // 무조건 0으로 시작하니까

        String[] Hex = {"A", "B", "C", "D", "E", "F"};  // 16진수일경우 알파벳 추가

        int num = 1;    // 1부터 시작 (0은 이미 넣었으니까)

        while (binary.length() - 1 < t * m) {   // 미리 구할 갯수 t * 참가 인원 m = 각자 몫 다 나올때까지
            StringBuilder sub = new StringBuilder("");
            int quot = num; // 몫
            int remain; // 나머지

            while (quot > 0) {
                remain = quot % n;
                quot = quot / n;

                if (remain >= 10 && remain <= 15) { // 16진수면 알파벳 추가
                    sub.append(Hex[remain - 10]);
                } else {
                    sub.append(remain);
                }
            }
            binary.append(sub.reverse());   // 진수 만들기 방식
            num++;  // 숫자 증가
        }

        int tube = p;   // 튜브의 순서
        for (int i = 0; i < t; i++) {
            answer.append(binary.charAt(tube - 1)); // 자기꺼 붙여줌
            tube += m;  // 순서 1바퀴마다 자기 차례 오니까
        }

        return answer.toString();

    }

    @Test
    public void 정답() {
        Assert.assertEquals("0111", solution(2, 4, 2, 1));
        Assert.assertEquals("02468ACE11111111", solution(16, 16, 2, 1));
    }
}


