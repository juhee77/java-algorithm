package 백준.lcs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_9252_LCS2Re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];

        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i - 1] == arr2[j - 1])
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        sb.append(dp[arr1.length][arr2.length]).append("\n");
        Stack<Character> s = new Stack<>();
        int i = arr1.length, j = arr2.length;
        while (0 < i && 0 < j) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                i--;
                j--;
                s.add(arr1[i]);
            }
        }
        while (!s.empty()) {
            sb.append(s.pop());
        }
        System.out.println(sb);

    }
}

