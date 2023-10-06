package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1943_동전분배_dp {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();

            if (input == null || input.equals("")) {
                //종료 조건
                break;
            }

            int coinCnt = Integer.parseInt(input);
            int[][] coinArr = new int[coinCnt][2];
            int goalMoney = 0;
            for (int i = 0; i < coinCnt; i++) {
                st = new StringTokenizer(br.readLine());
                coinArr[i][0] = Integer.parseInt(st.nextToken());
                coinArr[i][1] = Integer.parseInt(st.nextToken());
                goalMoney += coinArr[i][0] * coinArr[i][1];
            }

            if ((double) goalMoney % 2 != 0) {
                sb.append(0).append("\n"); //불가능
            } else {
                goalMoney /= 2;
                boolean[][] dp = new boolean[coinCnt + 1][goalMoney + 1];
                dp[0][0] = true;

                for (int j = 1; j <= coinCnt; j++) {
                    for (int i = 0; i <= goalMoney; i++) {

                        if (dp[j - 1][i]) {
                            for (int p = 0; p <= coinArr[j - 1][1]; p++) {
                                int nowMoney = p * coinArr[j - 1][0];
                                if (i + nowMoney <= goalMoney) dp[j][i + nowMoney] = true;
                            }
                        }

                    }
                }
                sb.append(dp[coinCnt][goalMoney] ? 1 : 0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
