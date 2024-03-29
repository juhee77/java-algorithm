package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2098_외판원순회_Re {

    private static final int INF = (int) 1e9;
    private static int city;
    private static int[][] map;
    private static int[][] dp;
    private static int end;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        city = Integer.parseInt(br.readLine());
        map = new int[city][city];
        end = (1 << city) - 1;
        dp = new int[city][end];

        for (int i = 0; i < city; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < city; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tps(0, 1));
    }

    private static int tps(int now, int bitmask) {
        if (bitmask == end) {
            if (map[now][0] == 0) {
                return INF;
            }
            return map[now][0];
        }

        if (dp[now][bitmask] != -1) {
            return dp[now][bitmask];
        }

        dp[now][bitmask] = INF;

        for (int i = 0; i < city; i++) {
            if (((1 << i) & bitmask) == 0 && map[now][i] != 0) {//방문 가능
                dp[now][bitmask] = Math.min(dp[now][bitmask], tps(i, bitmask | (1 << i)) + map[now][i]);
            }
        }
        return dp[now][bitmask];
    }
}
