package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1577_도로의개수_dfs {
    private static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dp = new long[n + 1][m + 1][3];
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (b != d) {
                if (b < d) dp[a][b][2] = -1;//가로로 가는길이 막힘
                else dp[c][d][2] = -1;
            } else {
                if (a < c) dp[a][b][1] = -1;//가로로 가는길이 막힘
                else dp[c][d][1] = -1;
            }
        }

        dp[0][0][0] = 1;
        System.out.println(dfs(n, m));
    }

    private static long dfs(int n, int m) {
        if (dp[n][m][0] != 0) return dp[n][m][0];
        long sum = 0;

        //가로로 가는길이 막힘
        if (m >= 1 && dp[n][m - 1][2] != -1) sum += dfs(n, m - 1);
        if (n >= 1 && dp[n - 1][m][1] != -1) sum += dfs(n - 1, m);
        return dp[n][m][0] = sum;
    }
}
