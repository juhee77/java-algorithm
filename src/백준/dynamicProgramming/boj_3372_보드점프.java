package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3372_보드점프 {
    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    private static int n;
    private static int[][] map;
    private static BigInteger[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new BigInteger[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], ZERO);
        }
        dp[0][0] = ONE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1) break;
                if (dp[i][j].equals(ZERO)) continue;

                if (i + map[i][j] < n) {
                    dp[i + map[i][j]][j] = dp[i + map[i][j]][j].add(dp[i][j]);
                }

                if (j + map[i][j] < n) {
                    dp[i][j + map[i][j]] = dp[i][j + map[i][j]].add(dp[i][j]);
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);

    }
}
