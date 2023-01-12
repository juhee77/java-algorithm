package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1719_택배 {
    private static final int INF = 400_000_000;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int sz = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int[][] dp = new int[sz + 1][sz + 1];
        map = new int[sz + 1][sz + 1];

        for (int i = 0; i <= sz; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }
        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], cost);
            dp[b][a] = Math.min(dp[b][a], cost);
        }

        for (int i = 1; i <= sz; i++) {
            for (int p = 1; p <= sz; p++) {
                for (int q = 1; q <= sz; q++) {
                    int temp;
                    if (dp[p][q] > dp[p][i] + dp[i][q]) {
                        temp = dfs(p, i);
                    } else {
                        if (map[p][q] == 0) temp = q;
                        else temp = map[p][q];
                    }
                    dp[p][q] = Math.min(dp[p][q], dp[p][i] + dp[i][q]);
                    map[p][q] = temp;
                }
            }
        }

        for (int i = 1; i <= sz; i++) {
            for (int j = 1; j <=  sz; j++) {
                if(i==j) sb.append("-");
                else sb.append(map[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int x, int y) {
        if(map[x][y]==y) return y;
        else return map[x][y]=dfs(x, map[x][y]);
    }
}
