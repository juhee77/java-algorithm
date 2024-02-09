package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2163_초콜릿자르기 {
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        dp = new int[row + 1][col + 1];
        dp[1][1] = 1;

        find(row, col);
        System.out.println(dp[row][col]);
    }

    private static int find(int row, int col) {
        System.out.println(dp.length + " " + row + " " + dp[0].length + " " + col);
        if (row <= 1 && col <= 1) {
            return dp[row][col];
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        if (row % 2 == 0) {
            return dp[row][col] = find(row / 2, col) + find(row / 2, col) + 1;
        } else if (col % 2 == 0) {
            return dp[row][col] = find(row, col / 2) + find(row, col / 2) + 1;
        } else {
            return dp[row][col] = Math.min(find(row / 2, col) + find(row / 2 + 1, col) + 1
                    , find(row, col / 2) + find(row, col / 2 + 1) + 1);
        }
    }
}
