package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_12852_1로만들기 {
    private static int dp[];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        dp = new int[num + 1];

        dp[1] = 0;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            if (i % 3 == 0) dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
        }

        sb.append(dp[num] + "\n");

        while (true) {
            sb.append(num + " ");
            if (num == 1) break;

            if (num % 3 == 0 && dp[num / 3] == dp[num] - 1) num = num / 3;
            else if (num % 2 == 0 && dp[num / 2] == dp[num] - 1) num = num / 2;
            else num = num - 1;
        }

//        while (true) {
//            sb.append(num + " ");
//            if (num == 1) break;
//            if (num % 6 == 0) {
//                if (dp[num - 1] < dp[num / 2] && dp[num - 1] < dp[num / 3]) num = num - 1;
//                else if (dp[num / 2] < dp[num - 1] && dp[num / 2] < dp[num / 3]) num = num / 2;
//                else num = num / 3;
//            } else if (num % 3 == 0) num = (dp[num / 3] > dp[num - 1]) ? num - 1 : num / 3;
//            else if (num % 2 == 0) num = (dp[num / 2] > dp[num - 1]) ? num - 1 : num / 2;
//            else num = num - 1;
//        }

        System.out.println(sb);

    }
}

