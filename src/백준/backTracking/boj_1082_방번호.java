package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1082_방번호 {
    private static int n;
    private static int[] p;
    private static int goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        goal = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][goal+1];
        for (int i = n; i >= 1; i--) {
            int now = p[i-1];
            for (int j = 1; j < goal+1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(j%now ==0 && j>=now){
                    dp[i][j] = Math.max(j / now, dp[i][j - now] + 1);
                }
            }
            System.out.println(Arrays.toString(dp[i]));
        }
    }

}
