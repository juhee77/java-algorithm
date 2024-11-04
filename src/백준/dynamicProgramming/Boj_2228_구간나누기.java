package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2228_구간나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 이전 값으로 초기화
                dp[i][j] = dp[i][j - 1];
                for (int k = 1; k <= j; k++) {
                    if (k >= 2) { // 구간을 나눌 수 있을 경우
                        dp[i][j] = Math.max(dp[i - 1][k - 2] + prefixSum[j] - prefixSum[k - 1], dp[i][j]);
                    } else if (k == 1 && i == 1) {
                        dp[i][j] = Math.max(dp[i][j], prefixSum[j]);  // 첫 번째 구간일 경우
                    }
                }
            }
        }

        System.out.println(dp[m][n]);
    }
}
