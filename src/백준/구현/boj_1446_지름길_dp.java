package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1446_지름길_dp {

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (Comparator.comparingInt(o -> o[0])));

        System.out.println(dp(d));
    }

    private static int dp(int d) {
        int[] dp = new int[d + 1];
        //초기 값 세팅
        for (int i = 0; i < d + 1; i++) {
            dp[i] = i;
        }

        for (int[] now : map) {
            if (now[1] <= d && dp[now[1]] > dp[now[0]] + now[2]) {
                dp[now[1]] = dp[now[0]] + now[2];
                //뒤를 이어서 채운다.
                for (int i = now[1]; i < d + 1; i++) {
                    dp[i] = Math.min(dp[i], dp[now[1]] + (i - now[1]));
                }
            }
        }
        return dp[d];
    }
}
