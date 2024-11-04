package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2228_구간나누기 {

    public static final int VAL = -((int) 1e9);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 배열 길이
        int m = Integer.parseInt(st.nextToken()); // 구간 수
        int[] arr = new int[n + 1];
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], VAL);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {  // 선택할 구간 수
            for (int j = 1; j <= n; j++) {  // 배열의 j번째 요소까지 고려
                for (int k = 1; k <= j; k++) {
                    if (i == 1 && k==1) {  // 첫 번째 구간 선택
                        dp[i][j] = Math.max(dp[i][j], prefixSum[j]);
                    } else if (i>=2 && k >= 2) {  // 구간 간 비인접 조건을 만족하도록 k-2 위치 확인
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k - 2] + prefixSum[j] - prefixSum[k - 1]);
                    }
                }
            }
//            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[m][n]);
    }
}
