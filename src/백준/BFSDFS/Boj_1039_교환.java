package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1039_교환 {
    private static int k;
    private static int max = -1;
    private static int nLen;
    private static int[][] dp = new int[11][1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        nLen = (int) Math.log10(n);
        k = Integer.parseInt(st.nextToken());

        dfs(n, 0);
//        Collections.sort(all, Collections.reverseOrder());
//        System.out.println(all);
        System.out.println(max);

    }

    public static int dfs(int now, int depth) {
        if (depth == k) {
            max = Math.max(max, now);
            return now;
        }

        if (dp[depth][now] != 0) {
            return dp[depth][now];
        }


        for (int i = 0; i <= nLen; i++) {
            int iPow = (int) Math.pow(10, i);
            int iEach = now / iPow % 10;
            for (int j = i + 1; j <= nLen; j++) {
                //두 숫자 바꾸기
                int jPow = (int) Math.pow(10, j);
                int jEach = now / jPow % 10;

                int temp = now - iEach * iPow - jEach * jPow + iEach * jPow + jEach * iPow;

                if ((int) Math.log10(temp) < nLen) continue;
//                System.out.printf("now %d :  %d %d -> temp %d \n ", now, i, j, temp);
                //계속해서 바꾸기(재귀)
                dp[depth][now] = Math.max(dp[depth][now], dfs(temp, depth + 1));
            }
        }
        return dp[depth][now];

    }
}
