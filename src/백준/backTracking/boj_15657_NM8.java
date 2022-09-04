package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15657_NM8 {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[][] visit;
    static int[] input;

    private static void dfs(int n, int m, int d) {
        if(d == m) {
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]) return ;
            }
            for(int a : arr) sb.append(a + " ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visit[d][i]) {
                visit[d][i] = true;
                arr[d] = input[i];
                dfs(n, m, d+1);
                visit[d][i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        input = new int[x];
        st  = new StringTokenizer(br.readLine());
        for(int i=0;i<x;i++)
            input[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(input);
        arr = new int[y]; visit = new boolean[x][x];
        dfs(x,y, 0);
        System.out.print(sb);

    }
}
