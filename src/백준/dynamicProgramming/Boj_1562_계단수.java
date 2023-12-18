package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1562_계단수 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n < 10) { //0~9까지 모든 숫자가 나올수 없다.
            System.out.println(0);
            return;
        }

        int[][][] dp = new int[n + 1][10][1 << 10]; //자리수, 사용 숫자, 각 숫자에서의 사용한 vistied의 개수

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int p = 0; p < 1024; p++) {
                    int afterVisit = p | (1 << j);
                    if (0 < j) {
                        dp[i][j][afterVisit] = (dp[i][j][afterVisit] + dp[i - 1][j - 1][p]) % MOD;
                    }
                    if (j < 9) {
                        dp[i][j][afterVisit] = (dp[i][j][afterVisit] + dp[i - 1][j + 1][p]) % MOD;
                    }
                }
            }


        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[n][i][1023];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
