package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10164_격자상의경로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (k == 0) {
            long[][] dp = new long[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][1] = 1;
            }
            for (int j = 1; j <= m; j++) {
                dp[1][j] = 1;
            }

            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[n][m]);
        } else {
            int r = (k - 1) / m + 1;
            int c = (k - 1) % m + 1;

            long[][] dp1 = new long[r + 1][c + 1];
            for (int i = 1; i <= r; i++) dp1[i][1] = 1;
            for (int j = 1; j <= c; j++) dp1[1][j] = 1;
            for (int i = 2; i <= r; i++) {
                for (int j = 2; j <= c; j++) {
                    dp1[i][j] = dp1[i - 1][j] + dp1[i][j - 1];
                }
            }

            long[][] dp2 = new long[n - r + 2][m - c + 2];
            for (int i = 1; i <= n - r + 1; i++) dp2[i][1] = 1;
            for (int j = 1; j <= m - c + 1; j++) dp2[1][j] = 1;
            for (int i = 2; i <= n - r + 1; i++) {
                for (int j = 2; j <= m - c + 1; j++) {
                    dp2[i][j] = dp2[i - 1][j] + dp2[i][j - 1];
                }
            }

            System.out.println(dp1[r][c] * dp2[n - r + 1][m - c + 1]);
        }
    }
}
