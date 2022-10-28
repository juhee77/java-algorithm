package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1937_욕심쟁이판다 {
    private static int[][] map;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        /*input*/
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //모든 노드를 시작 노드로 생각하고 계산
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt = Math.max(dfs(i, j), cnt);
            }
        }

        System.out.println(cnt);
    }

    private static int dfs(int x, int y) {
        int tmpMax = 1;

        if (dp[x][y] != 0) return dp[x][y];
        dp[x][y]=1;

        for (int i = 0; i < 4; i++) {
            int mvx = x + dir[i][0];
            int mvy = y + dir[i][1];

            //범위를 벗어남
            if (mvx < 0 || mvy < 0 || map.length <= mvx || map.length <= mvy) continue;

            //다음 건너가는 칸이 이번 칸보다 커야한다
            if (map[x][y] < map[mvx][mvy]) {
                tmpMax = Math.max(tmpMax, dp[x][y] + dfs(mvx, mvy));
            }
        }

        dp[x][y] = tmpMax;

        return dp[x][y];
    }
}