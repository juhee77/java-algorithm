package 프로그래머스.level1;

import java.util.Arrays;

public class Programmers_388351_유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int peopleCnt = timelogs.length;

        int[] schedulesTime = new int[schedules.length];
        for (int i = 0; i < schedulesTime.length; i++) {
            String temp = String.valueOf(schedules[i]);
            schedulesTime[i] = Integer.valueOf(temp.substring(0, temp.length() / 2)) * 60 + Integer.valueOf(temp.substring(temp.length() / 2));
        }

        boolean[] serve = new boolean[peopleCnt];
        Arrays.fill(serve, true);
        for (int i = 0; i < 7; i++) {
            int nowDay = (startday - 1 + i) % 7;
            if (nowDay < 5) {
                for (int j = 0; j < peopleCnt; j++) {
                    if (serve[j]) {
                        String temp = String.valueOf(timelogs[j][i]);
                        int now = Integer.valueOf(temp.substring(0, temp.length() / 2)) * 60 + Integer.valueOf(temp.substring(temp.length() / 2));
                        if (now > schedulesTime[j] + 10) {
                            serve[j] = false;
                        }
                    }
                }
            }
        }

        for (boolean s : serve)
            if (s) answer++;
        return answer;
    }

    public static void main(String[] args) {
        Programmers_388351_유연근무제 programmers388351_유연근무제 = new Programmers_388351_유연근무제();
        System.out.println(programmers388351_유연근무제.solution(new int[]{700, 800}, new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}
        }, 5));
    }
}
