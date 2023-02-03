package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2011_암호코드 {
    private static final int mod = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] num = br.readLine().toCharArray();
        if (num[0] == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[num.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= num.length; i++) {
            int now = num[i - 1] - '0';
            int before = num[i - 2] - '0';

            if (now == 0) {
                if (1 <= before && before <= 2) {
                    dp[i] = dp[i - 2] % mod;
                } else break;
            } else {
                if (before == 0) dp[i] = dp[i - 1] % mod;
                else {
                    if (before * 10 + now <= 26) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                    } else {
                        dp[i] = dp[i - 1] % mod;
                    }
                }
            }
        }
        System.out.println(dp[dp.length - 1] % mod);

    }
}
