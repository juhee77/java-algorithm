package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1562_계단수 {
    private static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n < 10) { //0~9까지 모든 숫자가 나올수 없다.
            System.out.println(0);
            return;
        }
        if (n == 10) {
            System.out.println(0);
        }


        int[][] dp = new int[n + 1][12];

        Arrays.fill(dp[1], 1);
        dp[1][0] = dp[1][1]= 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
            System.out.println(Arrays.toString(dp[i]));
        }

        long sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += dp[n][i];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
