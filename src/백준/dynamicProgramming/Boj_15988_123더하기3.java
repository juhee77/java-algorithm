package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15988_123더하기3 {

    public static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int nowHold = 3;
        while (n-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            if (nowHold <= temp) {
                for (int j = nowHold + 1; j <= temp; j++) {
                    dp[j] = ((dp[j - 1] + dp[j - 2]) % MOD + dp[j - 3]) % MOD;
                }
                nowHold = temp;
            }
            sb.append(dp[temp]).append("\n");
        }
        System.out.println(sb);
    }
}
