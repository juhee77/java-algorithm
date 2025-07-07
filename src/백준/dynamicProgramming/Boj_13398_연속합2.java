package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13398_연속합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[n]; // 제거하지 않은 최대 합
        int[] dpRemoved = new int[n]; // 하나 제거한 최대 합

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        dpRemoved[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            dpRemoved[i] = Math.max(dpRemoved[i - 1] + arr[i], dp[i - 1]); // 하나 제거
            max = Math.max(max, Math.max(dp[i], dpRemoved[i]));
        }
        System.out.println(max);
    }
}
