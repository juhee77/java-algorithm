package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2306_유전자 {
    private static int[][] dp;
    private static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().toCharArray();
        dp = new int[str.length ][str.length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        System.out.println(dfs(0, str.length - 1));

    }

    private static int dfs(int start, int end) {
        if (start >= end) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        int max = 0;
        for (int i = start; i < end; i++) {
            max = Math.max(max, dfs(start, i) + dfs(i + 1, end));
        }

        if (check(str[start], str[end])) {
            max = Math.max(max, dfs(start + 1, end - 1) + 2);
        }

        return dp[start][end] = max;
    }

    private static boolean check(char a, char b) {
        return (a == 'g' && b == 'c') || (a == 'a' && b == 't');
    }
}
