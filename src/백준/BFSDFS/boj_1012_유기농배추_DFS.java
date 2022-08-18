package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1012_유기농배추_DFS {
    private static boolean dfs(int arr[][],int x, int y){
        if(x>=arr.length || x<0 || y<0 || y>=arr[0].length) return false;

        //방문안한 노드이면
        if(arr[x][y] == 1) {
            arr[x][y] = 0;

            dfs(arr,x-1,y);
            dfs(arr,x+1,y);
            dfs(arr,x,y-1);
            dfs(arr,x,y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int tc=0;tc<TC;tc++) {
            st = new StringTokenizer(br.readLine());
            int col=Integer.parseInt(st.nextToken());
            int row =Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            int arr[][] = new int[row][col];
            //입력구간
            for(int i=0;i<line;i++){
                st = new StringTokenizer(br.readLine());
                int y=Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                arr[x][y]=1;
            }
            //dfs
            int cnt=0;
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(arr[i][j]==1)
                        if(dfs(arr,i,j)) cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }


        System.out.println(sb);

    }
}
