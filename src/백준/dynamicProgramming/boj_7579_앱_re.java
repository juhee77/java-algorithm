package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7579_앱_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());


        int get[] = new int[n];
        int pay[] = new int[n];

        /*입력*/
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) get[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pay[i] = Integer.parseInt(st.nextToken());

        int dp[][] = new int[n+1][100001];

        for(int i=1;i<=n;i++){
            for(int j=0;j<100001;j++){
                if(j==0)dp[i][j] = dp[i-1][j];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);

                if(j>=pay[i-1])dp[i][j]=Math.max(dp[i-1][j-pay[i-1]]+get[i-1],dp[i][j]);

            }
        }

        for(int i=0;i<100001;i++){
            if(goal<=dp[n][i]){
                System.out.println(i);
                break;
            }
        }

    }
}
