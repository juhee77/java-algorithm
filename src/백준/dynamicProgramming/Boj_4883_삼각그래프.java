package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4883_삼각그래프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            int row = Integer.parseInt(br.readLine());
            if (row == 0) {
                break;
            }

            int[][] arr = new int[row][3];
            int[][] dp = new int[row][3];

            for (int i = 0; i < row; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //중앙에서! 시작 하고 중앙으로 끝난다.
            dp[0][0] = 1_000_000_001;
            dp[0][1] = arr[0][1];
            dp[0][2] = dp[0][1] + arr[0][2];

            for (int i = 1; i < row; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i - 1][0], dp[i - 1][1]);

                dp[i][1] = arr[i][1] + Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), Math.min(dp[i - 1][2], dp[i][0]));

                dp[i][2] = arr[i][2] + Math.min(dp[i - 1][1], Math.min(dp[i - 1][2], dp[i][1]));


            }

//            for (int i = 0; i < row; i++) {
//                System.out.println(Arrays.toString(dp[i]));
//            }

            sb.append(tc++).append(". ").append(dp[row - 1][1]).append("\n");
        }
        System.out.println(sb);
    }

}
