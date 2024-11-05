package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2228_구간나누기 {

    public static final int MIN_VALUE = -((int) 1e9);  // 최소값 설정 (음수의 큰 값)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 배열 길이
        int m = Integer.parseInt(st.nextToken());  // 구간 개수
        int[] arr = new int[n + 1];
        int[] prefixSum = new int[n + 1];

        // 배열 값과 prefixSum 초기화
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], MIN_VALUE);  // dp 배열을 음수 최대값으로 초기화
        }

        dp[0][0] = 0;  // 시작값 초기화

        // 동적 프로그래밍 진행
        for (int i = 1; i <= m; i++) {  // 선택할 구간 수
            for (int j = 1; j <= n; j++) {  // j번째 요소까지 고려
                dp[i][j] = dp[i][j - 1];  // 초기화: j번째 요소를 선택하지 않는 경우
                for (int k = 1; k <= j; k++) {
                    if (k > 1) {  // 구간이 비인접 조건을 만족하도록 k-2 위치 확인
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k - 2] + (prefixSum[j] - prefixSum[k - 1]));
                    }
                }
            }
        }

        // m개의 구간을 선택했을 때 최대값 출력
        System.out.println(dp[m][n]);
    }
}
