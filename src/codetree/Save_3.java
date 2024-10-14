package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Save_3 {
    private static int[][] dp;
    private static int[][] arr;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        arr = new int[size][size];
        dp = new int[size + 1][size + 1];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = size - 1; 0 <= j; j--) {
                dp[i + 1][j] = arr[i][j] + Math.max(dp[i][j], dp[i+1][j + 1]);
            }
        }

        System.out.println(dp[size][0]);

    }
}