package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2758_로또 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        //선영이가 구매하는 로또의 개수를 구하여라
        //이전 숫자보다 두배이상 커야한다.
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            long[][] dp = new long[n + 1][m + 1]; //숫자 m까지 n개의 숫자를 뽑는 경우의 수

            Arrays.fill(dp[1], 1);
            dp[1][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = (int) Math.pow(2, i - 1); j <= m; j++) {
                    dp[i][j] += dp[i - 1][j / 2]; //현재값 /2보다 작은 모든 경우 i가 나올 수 있음
                    dp[i][j] += dp[i][j - 1];
                    //누적합 형식을 이용하기위해서 더한다. 이전숫자까지의 가능한 경우의 수를 더한다(더 작은 경우는 가능하기 때문에)
                }
            }
            sb.append(dp[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}
