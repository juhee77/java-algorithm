package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2195_문자열복사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();
        int[][] dp = new int[p.length + 1][s.length + 1];

        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < s.length; j++) {
                if (p[i] == s[j]) {
                    dp[i + 1][j + 1] = Math.max(1, dp[i][j] + 1);
                }
            }
        }

        int cnt = 0;
        int now = p.length;
        while (0 < now) {
            int asInt = Arrays.stream(dp[now]).max().stream().max().getAsInt();
            now -= asInt;
            cnt++;
        }
        System.out.println(cnt);
    }
}
