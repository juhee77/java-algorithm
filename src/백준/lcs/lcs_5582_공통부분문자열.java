package 백준.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lcs_5582_공통부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int str1Len = str1.length;
        int str2Len = str2.length;
        int max = 0;
        int[][] dp = new int[str1Len + 1][str2Len + 1];
        for (int i = 0; i < str1Len; i++) {
            for (int j = 0; j < str2Len; j++) {
                if (str1[i] == str2[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }

        System.out.println(max);
    }
}
