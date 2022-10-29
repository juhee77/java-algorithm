package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_2565_전깃줄_greedy {
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        map = new int[line][2];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, Comparator.comparingInt(o -> o[0]));

        int[][] dp = new int[501][501];
        int p = 0;
        for (int i = 1; i < 501; i++) {
            for (int j = 1; j < 501; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (p < line && map[p][0] == i && map[p][1] == j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + 1);
                    p++;
                }
            }
        }
        System.out.println(line - dp[500][500]);
    }
}
