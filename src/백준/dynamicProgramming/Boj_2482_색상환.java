package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2482_색상환 {
    private static final int MOD = 1000000003;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if (n / 2 < k) {
            System.out.println(0);
            return;
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[1][i] = dp[1][i - 1] + 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = i * 2 ; j <= n; j++) { //j개의 색상에서 i개를 고르는 경우
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j -2]) % MOD;
                //이전까지 안에서 뽑은 경우를 더한다. 이 전전 것을 선택한경우 이번것을 선택하는 경우
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[k][n]);

    }
}
