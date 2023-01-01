package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1965_상자넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int nums = Integer.parseInt(br.readLine());
        int[] num = new int[nums];
        st = new StringTokenizer(br.readLine());
        int[] dp = new int[nums];
        for (int i = 0; i < nums; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(num[j]<num[i] && dp[i]<=dp[j]){
                    dp[i]=dp[j]+1;
                }
            }
            max = Math.max(dp[i],max);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
