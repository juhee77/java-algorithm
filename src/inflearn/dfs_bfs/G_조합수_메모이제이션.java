package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_조합수_메모이제이션 {
    static int[][] dp = new int[34][34];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, r));
        System.out.println(DFS(n, r));

    }

    private static int solution(int n, int r) {
        if (dp[n][r] != 0) return dp[n][r];
        if (n == r || r == 0) return dp[n][r] = 1;
//        if (r == 1) return dp[n][r] = n;
//        if (n == r) return dp[n][r] = 1;
        return dp[n][r] = solution(n - 1, r - 1) + solution(n - 1, r);
    }


    static int[][] dy = new int[35][35];

    /*=== ans ===*/
    public static int DFS(int n, int r) {
        if (dy[n][r] > 0) return dy[n][r];
        if (n == r || r == 0) return 1;
        else return dy[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
    }
}
