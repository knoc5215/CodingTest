package boj;

import java.util.Scanner;

public class p2884 {
    public static final int DAY_HOUR = 23;
    public static final int DAY_MINUTE = 60;
    public static final int EARLY_ALARM_MINUTE = 45;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();

        int alarmHour, alarmMinute;
        if (minute - EARLY_ALARM_MINUTE >= 0) {
            alarmHour = hour;
            alarmMinute = minute - EARLY_ALARM_MINUTE;
        } else {
            alarmMinute = DAY_MINUTE - (Math.abs(minute - EARLY_ALARM_MINUTE));
            if (hour < 1) {
                alarmHour = DAY_HOUR;
            } else {
                alarmHour = hour - 1;
            }
        }

        System.out.println(alarmHour + " " + alarmMinute);
    }
}
