package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2133_타일채우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        System.out.println(solution(input));
    }

    private static int solution(int input) {
        //홀수는 존재하지 않음
        if (input % 2 == 1) return 0;

        int[] dp = new int[31];
        dp[2] = 3;
        dp[4] = 11;
        if (input <= 4) return dp[input];

        for (int i = 6; i < input + 1; i++) {
            for (int j = 2; j < i - 2; j += 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += dp[i - 2] * 3;
            dp[i] += 2;
        }
        return dp[input];
    }
}
