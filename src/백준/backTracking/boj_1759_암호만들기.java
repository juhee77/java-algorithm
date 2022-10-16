package 백준.backTracking;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_암호만들기 {
    private static char[] arr;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();
    //private static char[] in //재귀적으로 출려배열 쓰지 않고 하는 방법 있을듯;
    private static void dfs(int nowd, int d, int start){
        if(nowd==d){
            int aeiou = 0;
            int other=0;
            for(int i=0;i<visited.length;i++){
                if(visited[i]) {
                    if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u') aeiou++;
                    else other++;
                }
            }
            if(aeiou>=1 && other>=2){
                for(int i=0;i<visited.length;i++){
                    if(visited[i])sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }
        else {
            for(int i=start;i<arr.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    dfs(nowd+1,d,i);
                    visited[i]=false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<C;i++)arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);


        dfs(0,L,0);
        System.out.println(sb);
    }
}
