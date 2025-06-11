package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14863_서울에서경산까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int limitTime = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][limitTime + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            for (int t = 0; t <= limitTime; t++) {
                if (dp[i][t] == -1) continue;

                int movedTime = t + temp[0];
                if (movedTime <= limitTime) {
                    dp[i + 1][movedTime] = Math.max(dp[i + 1][movedTime], dp[i][t] + temp[1]);
                }

                int movedTime2 = t + temp[2];
                if (movedTime2 <= limitTime) {
                    dp[i + 1][movedTime2] = Math.max(dp[i + 1][movedTime2], dp[i][t] + temp[3]);
                }
            }
        }

        int answer = 0;
        for (int t = 0; t <= limitTime; t++) {
            answer = Math.max(answer, dp[n][t]);
        }
        System.out.println(answer);
    }
}
