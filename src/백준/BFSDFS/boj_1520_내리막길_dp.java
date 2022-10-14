package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1520_내리막길_dp {
    private static int[][] dp;
    private static int[][] map;
    private static int row = 0, col = 0;
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


    private static int bfs(int x, int y) {

        if(dp[x][y]!=-1) return dp[x][y]; // 이미 값이 있으면

        dp[x][y]=0;
        for (int i = 0; i < 4; i++) {
            int mvx = x - dir[i][0];
            int mvy = y - dir[i][1];

            if (row <= mvx || mvx < 0 || col <= mvy || mvy < 0) continue;//범위를 벗어남

            if (map[mvx][mvy] >map[x][y]) {
                dp[x][y] += bfs(mvx, mvy);
            }
        }

        return dp[x][y];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(dp[i],-1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]=1;
        System.out.println(bfs(row - 1, col - 1));

    }
}
