package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15788_밸런스스톤 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        long[] rowSum = new long[n];
        long[] colSum = new long[n];
        long[] crossSum = new long[2];
        int x=-1,y=-1;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==0){
                    x=i;
                    y=j;
                }
                rowSum[i]+=arr[i][j];
                colSum[j]+=arr[i][j];
                if(i==j)crossSum[0] +=arr[i][j];
                if(i==n-j-1)crossSum[1]+=arr[i][j];
            }
        }

        long guess = rowSum[(x+1)%2]-rowSum[x];
        rowSum[x]+=guess;
        colSum[y]+=guess;
        if(x==y) crossSum[0]+=guess;
        if(x==n-y-1)crossSum[1]+=guess;

        if(checking(rowSum) && checking(colSum) && checking(crossSum)){
            System.out.println(guess);
        }else{
            System.out.println(-1);
        }
    }

    private static boolean checking(long[] rowSum) {
        long hold = rowSum[0];
        for(int i=1;i<rowSum.length;i++){
            if(hold!=rowSum[i]) return false;
        }
        return true;
    }
}
