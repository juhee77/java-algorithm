package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9576_책나눠주기 {
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC --> 0){
            max = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int book = Integer.parseInt(st.nextToken());
            int pnum = Integer.parseInt(st.nextToken());
            boolean visited[] = new boolean[book];
            int arr[][] = new int[pnum][2];

            for(int i=0;i<pnum;i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken())-1;
                arr[i][1] = Integer.parseInt(st.nextToken())-1;
            }

            dfs(visited,arr,0,pnum,0);
            sb.append(max).append('\n');
        }
        System.out.println(sb);
    }

    private static void dfs(boolean[] visited, int[][] arr, int d, int n,int cnt) {
        if(max !=0 ) return;
        if(d==n){
            System.out.println(Arrays.toString(visited));
            max = Math.max(max,cnt);
        }
        else{
            int start = arr[d][0];
            int end = arr[d][1];

            for(int i=start;i<=end&&i<visited.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(visited,arr,d+1,n,cnt+1);
                    visited[i]=false;
                }
            }
            dfs(visited,arr,d+1,n,cnt);
        }
    }
}
