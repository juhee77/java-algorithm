package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2755_부녀회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC= Integer.parseInt(br.readLine());
        int arr[][] = new int[15][15];
        for(int i=1;i<15;i++) arr[0][i]= i;

        int savepoint = 0;
        for(int tc=0;tc<TC;tc++) {
            int n=Integer.parseInt(br.readLine());
            int k=Integer.parseInt(br.readLine());
            if(arr[n][k] != 0 ) sb.append(arr[n][k]).append('\n');
            else {
                for(int i=savepoint+1 ;i<=n;i++){
                    arr[i][1]=1;
                    for(int j= 2;j<15;j++){
                        arr[i][j]=arr[i][j-1]+arr[i-1][j];
                    }
                }
                sb.append(arr[n][k]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
