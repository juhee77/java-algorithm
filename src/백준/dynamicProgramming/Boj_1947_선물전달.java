package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1947_선물전달 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(calculateDerangement(n));
    }

    // 교란 순열(derangement)
    public static long calculateDerangement(int n) {
        if (n == 0) return 1;
        if (n == 1) return 0;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
            dp[i] %= MOD;
        }

        return dp[n];
    }
}
