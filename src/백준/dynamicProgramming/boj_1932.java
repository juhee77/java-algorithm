package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        long arr[][] = new long[line+1][line+1];
        long max = 0;

        for(int i=1;i<=line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j] = Math.max(arr[i-1][j-1],arr[i-1][j])+Long.parseLong(st.nextToken());
                max=Math.max(max,arr[i][j]);
            }

        }
        sb.append(max);
        System.out.println(sb);
    }
}
