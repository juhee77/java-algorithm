package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_16565_N포커 {
    private static final int MOD = 10007;
    private static int[][] comb = new int[53][53];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 조합 값 미리 계산
        for (int i = 0; i <= 52; i++) {
            comb[i][0] = 1; // nC0 = 1
        }
        for (int i = 1; i <= 52; i++) {
            for (int j = 1; j <= 52; j++) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD;
            }
        }

        int ans = 0;
        for (int i = 1; i <= 13 && n - 4 * i >= 0; i++) {
            int term = (comb[52 - 4 * i][n - 4 * i] * comb[13][i]) % MOD;
            if (i % 2 == 1) {
                ans = (ans + term) % MOD;
            } else {
                ans = (ans - term + MOD) % MOD; // 음수 방지
            }
        }
        System.out.println(ans);
    }
}
