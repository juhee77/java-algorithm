package 백준.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1958_lcs3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] aStr = br.readLine().toCharArray();
        char[] bStr = br.readLine().toCharArray();
        char[] cStr = br.readLine().toCharArray();

        int[][][] dp = new int[aStr.length + 1][bStr.length + 1][cStr.length + 1];

        for (int i = 1; i <= aStr.length; i++) {
            for (int j = 1; j <= bStr.length; j++) {
                for (int k = 1; k <= cStr.length; k++) {
                    dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
                    if (aStr[i - 1] == bStr[j - 1] && bStr[j - 1] == cStr[k - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k - 1] + 1);
                    }
                }
            }
        }
        System.out.println(dp[aStr.length][bStr.length][cStr.length]);
    }
}
