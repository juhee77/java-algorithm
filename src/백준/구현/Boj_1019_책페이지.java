package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1019_책페이지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int end = Integer.parseInt(br.readLine());
        int[] dp = new int[10];
        int start = 1;
        int nowPint = 1;
        while (start <= end) {
            while (end % 10 != 9 && start <= end) {
                countDigits(end--, dp, nowPint);
            }

            while (start % 10 != 0 && start <= end) {
                countDigits(start++, dp, nowPint);
            }

            if (start > end) break;

            start /= 10;
            end /= 10;
            for (int i = 0; i < 10; i++) {
                dp[i] += (end - start + 1) * nowPint;
            }

            nowPint *= 10;
        }

        for (int i : dp) {
            System.out.printf(i + " ");
        }
    }

    private static void countDigits(int x, int[] dp, int point) {
        while (x > 0) {
            dp[x % 10] += point;
            x /= 10;
        }
    }
}
