package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_격자판최대합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int [num][num];
        int sum[] =new int[num+2];
        int max=0;
        //행은 그냥 계산 가능 , 대각선, 열 만 저장

         for(int i=0;i<num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSum = 0;
            for(int j=0;j<num;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[j] += arr[i][j]; // 열
                rowSum += arr[i][j]; // 행
            }
            max = Math.max(max, rowSum); // 행중의 최대값
            sum[num] += arr[i][i]; //대각선
            sum[num+1] += arr[i][num-i-1];
         }

         for(int e: sum) max=Math.max(max,e);

         System.out.println(max);

    }
}
