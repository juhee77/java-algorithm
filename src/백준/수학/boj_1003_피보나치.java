package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1003_피보나치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        int dp[][] = new int[41][2];
        //setting
        dp[0][0] = dp[1][1] = 1;
        dp[0][1] = dp[1][0] = 0;

        int now =1; //어디까지 저장되었는지 저장

        for (int i = 0; i < line; i++) {
            int x = Integer.parseInt(br.readLine());

            for (int p = now+1; p <= x; p++) {
                dp[p][0]=dp[p-1][0]+dp[p-2][0];
                dp[p][1]=dp[p-1][1]+dp[p-2][1];
                now=p;
            }

            sb.append(dp[x][0]+" "+dp[x][1]).append("\n");
        }
        System.out.println(sb);
    }
}
