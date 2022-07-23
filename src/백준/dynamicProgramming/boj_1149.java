package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        long arr[][] = new long[line+1][3];

        for(int i=1;i<=line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Math.min(arr[i-1][1],arr[i-1][2])+Long.parseLong(st.nextToken());
            arr[i][1] = Math.min(arr[i-1][0],arr[i-1][2])+Long.parseLong(st.nextToken());
            arr[i][2] = Math.min(arr[i-1][0],arr[i-1][1])+Long.parseLong(st.nextToken());

        }
        sb.append(Math.min(Math.min(arr[line][0],arr[line][1]),arr[line][2]));
        System.out.println(sb);
    }
}
