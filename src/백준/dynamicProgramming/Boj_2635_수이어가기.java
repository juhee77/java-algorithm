package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2635_수이어가기 {
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        dp = new int[n + 1];
        int next = -1;

        //임의의 수
        for (int i = n; n / 2 < i; i--) {
            if (dp[i] == 0) dfs(n, i);

            if (max < dp[n]) {
                next = i;
                max = dp[n];
            }
        }

        sb.append(max).append("\n");
        int a = n, b = next;
        sb.append(a).append(" ").append(b);
        while (0 <= a - b) {
            int c = a - b;
            sb.append(" ").append(c);
            a = b;
            b = c;
        }

        System.out.println(sb);
    }

    public static int dfs(int a, int b) {
        int c = a - b;
        if (0 <= c) {
            if (dp[b] != 0) dp[a] = dp[b] + 1;
            dp[a] = dfs(b, c) + 1;
        } else dp[a] = 2; //a,b두개는 취하기때문에

        return dp[a];
    }

}
