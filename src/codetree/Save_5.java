package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Save_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) dp[i + 1] = dp[i] + 1;
            else dp[i + 1] = dp[i];
        }

        int left = 1, right = 1;
        int maxLen = 0;

//        System.out.println(Arrays.toString(dp));
        while (left <= right && right <= n) {
            int diff = dp[right] - dp[left - 1];
            if (diff <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        System.out.println(maxLen);

    }
}