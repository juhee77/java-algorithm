package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9656_돌게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[2] = 1; //이긴다 1,3 진다

        for (int i = 4; i <= n; i++) {
            if (dp[i - 1] + dp[i - 3] < 2) {
                dp[i] = 1;
            }
        }

        System.out.println(dp[n] == 1 ? "SK" : "CY");
    }
}