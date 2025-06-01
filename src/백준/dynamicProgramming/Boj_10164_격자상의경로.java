package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10164_격자상의경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int row = k / m + 1;
        int col = (k % m == 0) ? m : k % m;
        int[][] dp = new int[row + 1][col + 1];

        dp[1][1] = 1;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + dp[i][j - 1]);
            }
        }

        int[][] dp2 = new int[n + 1][m + 1];
        if (k == 0) dp2[1][1] = 1;
        else dp2[row][col] = dp[row][col];

        for (int i = Math.max(1, row); i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp2[i][j] = Math.max(dp2[i][j], dp2[i - 1][j] + dp2[i][j - 1]);
            }
        }

        System.out.println(dp2[n][m]);

    }
}
