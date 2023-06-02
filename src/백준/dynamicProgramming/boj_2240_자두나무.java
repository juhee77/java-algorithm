package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2240_자두나무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] score = new int[T + 1][W + 1];
        for (int i = 1; i <= T; i++) {
            int now = Integer.parseInt(br.readLine()) - 1;

            for (int j = 0; j <= W; j++) {
                if (j == 0) score[i][j] = score[i - 1][j];
                else score[i][j] = Math.max(score[i - 1][j], score[i][j - 1]);

                if (now == j % 2) score[i][j]++;
            }
        }
        System.out.println(score[T][W]);
    }
}
