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

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;

        for (int j = 1; j <= m; j++) {
            for (int i = j; i <= n; i++) {
                for (int k = j - 1; k < i; k++) {
                    int currentSum = prefixSum[i] - prefixSum[k];
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + currentSum);
                }
            }
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxSum = Math.max(maxSum, dp[i][m]);
        }
        System.out.println(maxSum);
    }
}
