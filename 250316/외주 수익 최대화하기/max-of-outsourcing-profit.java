import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[20][20];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[i][i + b] = c;
        }

        // i에서 j일 걸리는 일의 가장 높은 비용

        for (int p = 0; p < n; p++) {
            for (int q = 0; q < 20; q++) {
                int diff = q - p; // duringDay
                if (p >= 1 && dp[p][q] != 0) {
                    dp[p][q] = Integer.max(dp[p][q], dp[p - 1][q - diff] + dp[p][q]);
                }

                if (q >= 1) {
                    dp[p][q] = Math.max(dp[p][q], dp[p][q - 1]);
                }
                if (p!=0) {
                    dp[p][q] = Math.max(dp[p - 1][q],dp[p][q]);
                }
            }

//            System.out.println(Arrays.toString(dp[p]));
        }
        System.out.println(dp[n-1][19]);


    }

}
