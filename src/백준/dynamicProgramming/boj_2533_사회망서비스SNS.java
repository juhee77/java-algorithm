package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2533_사회망서비스SNS {
    private static int[][] dp;
    private static boolean[] visited;
    private static final List<List<Integer>> graphs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        visited = new boolean[line];
        dp = new int[line][2]; //방문 한 경우와 하지 않은 경우로 나누어서
        for(int i=0;i<line;i++){
            graphs.add(new ArrayList<>());
        }

        while(line --> 1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parents = Integer.parseInt(st.nextToken())-1;
            int child = Integer.parseInt(st.nextToken())-1;
            graphs.get(parents).add(child);
            graphs.get(child).add(parents);
        }

        dfs(0);
        System.out.println(Math.min(dp[0][0],dp[0][1]));
    }

    private static void dfs(int parent) {
        visited[parent] = true;
        dp[parent][1]=1;

        for(int i=0;i<graphs.get(parent).size();i++){
            int child = graphs.get(parent).get(i);
            if(visited[child])continue;
            dfs(child);

            dp[parent][0] += dp[child][1]; //내가 얼리 어답터가 아니므로 자식은 모두 얼리 어답터여야 한다.
            dp[parent][1] += Math.min(dp[child][0],dp[child][1]);  //내가 얼리 어답터 이므로 상관없다.
        }
    }
}
