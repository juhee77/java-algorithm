package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10164_격자상의경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());
        int row = k/n;
        int col = k%n;

        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        int[][] dp2 = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {

        }



    }
}
