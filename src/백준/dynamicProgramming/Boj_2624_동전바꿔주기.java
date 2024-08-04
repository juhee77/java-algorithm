package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2624_동전바꿔주기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int coinS = Integer.parseInt(br.readLine());
        int[][] coin = new int[coinS][2];

        for (int i = 0; i < coinS; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.parseInt(st.nextToken());
            coin[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] before;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < coinS; i++) {
            before = dp.clone();

            for (int j = 0; j < n; j++) {
                if (before[j] != 0) {
                    int hold = j + coin[i][0];
                    for (int k = 1; k <= coin[i][1]; k++) {
                        if (hold <= n) {
                            dp[hold] += before[j];
                            hold += coin[i][0];
                        } else break;
                    }
                }
            }
        }
        System.out.println(dp[n]);
    }
}
