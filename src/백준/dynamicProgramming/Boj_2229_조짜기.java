package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2229_조짜기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int min = score[i - 1];
            int max = score[i - 1];

            for (int j = i; j <= n; j++) {
                min = Math.min(min, score[j - 1]);
                max = Math.max(max, score[j - 1]);

                dp[i][j] = Math.max(dp[i - 1][i - 1] + (max - min), dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
            }
//            System.out.println(max + " " + min);
//            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println(dp[n][n]);
    }
}
