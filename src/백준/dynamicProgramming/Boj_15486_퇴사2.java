package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15486_퇴사2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] table = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            //현재 시점에서 상담이 끝나는날
            int nextDay = table[i][0] + i;
            if (0 < i) dp[i] = Math.max(dp[i - 1], dp[i]);
            if (nextDay <= n) dp[nextDay] = Math.max(dp[nextDay], dp[i] + table[i][1]);
        }
        dp[n] = Math.max(dp[n], dp[n - 1]);
        System.out.println(dp[n]);
    }
}
