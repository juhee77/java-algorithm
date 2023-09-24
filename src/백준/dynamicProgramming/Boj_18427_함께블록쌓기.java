package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18427_함께블록쌓기 {
    private static final int MOD = 10_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][h + 1];

        for (int i = 1; i <= n; i++) {

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int now = Integer.parseInt(st.nextToken());
                if (h < now) continue;

                map[i][now] = (map[i][now] + 1) % MOD;

                for (int j = 0; j <= h; j++) {
                    if (0 <= j - now) { // 가능한 경우만 지속한다.
                        map[i][j] = (map[i][j] + map[i - 1][j - now]) % MOD;
                    }
                }
            }

            for (int j = 0; j <= h; j++) {
                //이전 칸을 복사 한다.
                map[i][j] = (map[i - 1][j] + map[i][j]) % MOD;
            }
        }

        System.out.println(map[n][h]);
    }
}
