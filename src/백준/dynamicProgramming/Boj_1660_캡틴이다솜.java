package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1660_캡틴이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] single = new int[Math.max(n + 1, 3)]; //단면
        int[] multi = new int[Math.max(n + 1, 3)]; // 사면체
        int max = 0;
        single[1] = multi[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (single[i] == 0)
                single[i] = single[i - 1] + i;

            if (n <= single[i])
                break;
        }

        for (int i = 2; i <= n; i++) {
            if (multi[i] == 0)
                multi[i] = multi[i - 1] + single[i];

            if (n <= multi[i]) {
                max = i;
                break;
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 1; j <= max; j++) {
                int next = i + multi[j];
                if (next <= n) {
                    dp[next] = Math.min(dp[next], dp[i] + 1);
                }
            }
        }

        if (dp[n] == Integer.MAX_VALUE) {
            System.out.println(-1); // 도달 불가능한 경우
        } else {
            System.out.println(dp[n]); // 최소 연산 횟수
        }

    }
}
