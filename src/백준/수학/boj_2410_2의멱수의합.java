package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2410_2의멱수의합 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        dp[1] = 1L;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) dp[i] = dp[i - 1] + dp[i/2];
            else dp[i] = dp[i - 1];
            dp[i] %= MOD;
        }
        System.out.println(dp[n]);
    }
}
