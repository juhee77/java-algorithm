package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2253_점프 {
    private final static int MAX = 10000000;
    private final static int MMAX = 20000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int v = (int) Math.sqrt(2 * n);
        int[][] dp = new int[n + 1][v + 2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], MAX);
        }
        while (m-- > 0) {
            int now = Integer.parseInt(br.readLine());
            Arrays.fill(dp[now], MMAX);
        }

        dp[1][0] = 0;
        //현재칸에서 지금 건너갈 수 있는 range 칸일때 점프 횟수
        for (int i = 2; i <= n; i++) {
            if (dp[i][0] == MMAX) continue;

            for (int j = 1; j < Math.sqrt(2 * i); j++) {
                dp[i][j] = Math.min(Math.min(dp[i - j][j - 1], dp[i - j][j]), dp[i - j][j + 1]) + 1;
            }

        }

        int ans = MAX;
        for (int i = 1; i <= v; i++) {
            ans = Math.min(ans, dp[n][i]);
        }

        System.out.println(ans == MAX ? -1 : ans);

    }
}