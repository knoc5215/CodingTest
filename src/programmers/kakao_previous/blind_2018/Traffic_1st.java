package programmers.kakao_previous.blind_2018;

public class Traffic_1st {
    public static int solution(String[] lines) {
        int answer = 0;

        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];

        getTimes(lines, startTimes, endTimes);
        // 1. 로그 시작점을 윈도우로
        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int START = startTimes[i];
            int END = START + 1000;

            for (int j = 0; j < lines.length; j++) {
                if (START <= startTimes[j] && startTimes[j] < END) {    // START END 사이에 시작하거나 (범위에 로그가 포함)
                    cnt++;
                } else if (startTimes[j] <= START && endTimes[j] >= END) {  // START보다 먼저 시작하고 END보다 늦게 끝나거나 (로그에 범위가 포함)
                    cnt++;
                } else if (START <= endTimes[j] && endTimes[j] < END) { // START보다 늦게 끝나면서 END보다 먼저 끝나거나 (범위안에 끝남)
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt); // 최대값 갱신

        }

        // 2. 로그 끝점을 윈도우로
        for (int i = 0; i < lines.length; i++) {
            int cnt = 0;
            int START = endTimes[i];
            int END = START + 1000;

            for (int j = 0; j < lines.length; j++) {
                if (START <= startTimes[j] && startTimes[j] < END) {
                    cnt++;
                } else if (startTimes[j] <= START && endTimes[j] >= END) {
                    cnt++;
                } else if (START <= endTimes[j] && endTimes[j] < END) {
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);

        }


        return answer;
    }

    // 2016-09-15 03:10:33.020 0.011s
    // 로그에서 시작점, 끝점 구한다 (밀리초 단위로 통일)
    static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
        for (int i = 0; i < lines.length; i++) {
            String[] log = lines[i].split(" "); // 2016-09-15, 03:10:33.020, 0.011s
            String[] responseTime = log[1].split(":");  // 03, 10, 33.020

            int processingTime = (int) (Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);   // 0.011 * 1000
            int startTime = 0;
            int endTime = 0;

            endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;  // 시간 -> 밀리초
            endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;   // 분 -> 밀리초
            endTime += (int) (Double.parseDouble(responseTime[2]) * 1000);  // 초 -> 밀리

            startTime = endTime - processingTime + 1;

            startTimes[i] = startTime;
            endTimes[i] = endTime;
        }
    }
}
