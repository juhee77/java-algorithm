package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10653_마라톤2Re {
    private static int[][] dp;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int canPassed = Integer.parseInt(st.nextToken());
        int[][] points  = new int[size][2];

        for(int i = 0; i< size; i++){
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        dist = new int[size][size];
        dp = new int[size][canPassed+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        for(int i = 0; i< size; i++){
            for(int j = i+1; j< size; j++){
                dist[i][j] = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
            }
        }
        System.out.println(findMin(size -1, canPassed));

    }

    private static int findMin(int now, int nowPassed) {
        if(now==0) return 0;
        if(dp[now][nowPassed]!=-1) return dp[now][nowPassed]; //방문 처리

        int min = Integer.MAX_VALUE;
        for(int i=0;i<=nowPassed;i++){
            if(now-i-1<0) continue;
            min = Math.min(min,findMin(now-i-1,nowPassed-i)+dist[now-i-1][now]);
        }
        return dp[now][nowPassed]=min;
    }
}
