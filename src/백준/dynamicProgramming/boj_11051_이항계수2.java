package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11051_이항계수2 {
    private static int[][] dp;
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[n + 1][k + 1];

        System.out.println(solution(n, k));

    }

    private static int solution(int n, int k) {
        if (dp[n][k] > 0) return dp[n][k];
        if (k == 0 || n == k) return dp[n][k] = 1;
        return dp[n][k] = (solution(n - 1, k - 1) + solution(n - 1, k)) % MOD;
    }
}
