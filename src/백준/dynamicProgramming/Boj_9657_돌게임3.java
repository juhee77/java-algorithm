package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9657_돌게임3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stone = Integer.parseInt(br.readLine());
        //두 사람이 완벽하게게임을 했을때 이기는 사람
        //1,3,4


        int[] dp = new int[1001];
        dp[1] = dp[3] = dp[4] = 1; //상근

        for (int j = 5; j <= stone; j++) {
            //턴이 누구 인가
            if (dp[j - 1] + dp[j - 3] + dp[j - 4] < 3) {
                //내가 이길 수 있는 경우가 하나라도 있다면
                dp[j] = 1;
            }
        }

        if (dp[stone] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }
}
