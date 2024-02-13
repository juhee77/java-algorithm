package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2253_점프 {
    private static int MAX = (int) 100000;
    private static int MMAX = (int) 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int v = (int)Math.sqrt((n + 1));
        int[][] dp = new int[n + 1][v+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], MAX);
        }
        while (m-- > 0) {
            int now = Integer.parseInt(br.readLine());
            Arrays.fill(dp[now], MMAX);
        }

        dp[1][1] = 1;
        //현재칸에서 지금 건너갈 수 있는 range 칸일때 점프 횟수
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j <= v; j++) {
                if (dp[i][j] != MAX && dp[i][j] != MMAX) {
                    if (i + j + 1 <= v  && dp[i + j + 1][j + 1] != MMAX) {
                        dp[i + j + 1][j + 1] = Math.min(dp[i + j + 1][j + 1], dp[i][j] + 1);
                    }
                    if (i + j <= v  && dp[i + j][j] != MMAX) {
                        dp[i + j][j] = Math.min(dp[i + j][j], dp[i][j] + 1);
                    }
                    if (i + j - 1 <= v  && dp[i + j - 1][j - 1] != MMAX) {
                        dp[i + j - 1][j - 1] = Math.min(dp[i + j - 1][j - 1], dp[i][j] + 1);
                    }
                }
            }

        }

        int ans = MAX;
        for (int i = 1; i <= v; i++) {
            System.out.println(Arrays.toString(dp[i]));
            ans = Math.min(ans, dp[v][i]);
        }

        System.out.println(ans == MAX || ans == 0 ? -1 : ans - 1);

    }
}
