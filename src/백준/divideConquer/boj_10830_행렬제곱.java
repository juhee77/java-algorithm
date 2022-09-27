package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10830_행렬제곱 {

    public static int[][] matrixSquare(int[][] arr , long n){
        if(n==1) return arr;

        if(n%2==0){
            int[][] tmp = matrixSquare(arr,n/2);
            return duplix(tmp,tmp);
        }
        else{
            int[][] tmp = matrixSquare(arr,(n-1)/2);
            return duplix(duplix(tmp,tmp),arr);
        }
    }

    public static int[][] duplix (int [][] arr1, int[][] arr2){
        int tmp[][]= new int[arr1.length][arr1.length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j< arr1.length;j++){
                for(int k=0;k<arr1.length;k++){
                    tmp[i][j] += arr1[i][k]%1000*arr2[k][j]%1000;
                }
                tmp[i][j]%=1000;
            }
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st =new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());
        long n = Long.parseLong(st.nextToken());

        int arr[][] = new int[line][line];
        //입력구간
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++)
                arr[i][j] = Integer.parseInt(st.nextToken())%1000;
        }

        int[][] ans = matrixSquare(arr,n);
        for(int i=0;i<line;i++){
            for(int j=0;j<line;j++){
                sb.append(ans[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
