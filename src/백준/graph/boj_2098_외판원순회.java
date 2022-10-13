package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2098_외판원순회 {
    private static final int INF = 987654321;
    private static int city;
    private static int[][] map;
    private static int[][] dp;
    private static int end;

    private static int dfs(int now, int bitmask){
        if(bitmask==end) //모든 도시 방문한경우
            return (map[now][0]==0)?INF:map[now][0];

        if(dp[now][bitmask]!=-1) //이미 같은 경로로 방문한적이 있음
            return dp[now][bitmask];

        dp[now][bitmask]= INF;

        for(int i=0;i<city;i++){
            if((bitmask&(1<<i))==0 && map[now][i]!=0){
                dp[now][bitmask] = Math.min(dp[now][bitmask],dfs(i,bitmask|(1<<i))+map[now][i]);
            }
        }
        return dp[now][bitmask];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        city = Integer.parseInt(br.readLine());
        map = new int[city][city];
        end = (1<<city)-1;
        dp = new int[city][end]; //1을 5번 이동하면 100000(2) 이고 -1하면 11111(2) 31이다

        for(int i=0;i<city;i++){
            Arrays.fill(dp[i],-1);
            st  = new StringTokenizer(br.readLine());
            for(int j=0;j<city;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0,1));
    }
}
/*
Input:
16
0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1
0 1 1 0 1 1 1 1 1 1 1 1 1 1 1 1
0 1 1 1 0 1 1 1 1 1 1 1 1 1 1 1
0 1 1 1 1 0 1 1 1 1 1 1 1 1 1 1
0 1 1 1 1 1 0 1 1 1 1 1 1 1 1 1
0 1 1 1 1 1 1 0 1 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1
0 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1
0 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1
0 1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
0 1 1 1 1 1 1 1 1 1 1 1 0 1 1 1
0 1 1 1 1 1 1 1 1 1 1 1 1 0 1 1
0 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1
0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0

Output:
16
 */
