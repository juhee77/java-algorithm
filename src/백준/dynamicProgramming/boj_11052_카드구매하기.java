package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11052_카드구매하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int goal = Integer.parseInt(br.readLine());
        int arr[] = new int[goal+1];
        int sum[] = new int[goal+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= goal; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i];
        }

        for(int i=1;i<=goal;i++){
            for(int j=1;j<i;j++){
                sum[i] = Math.max(sum[i],sum[i-j] + arr[j]);
            }
        }

        System.out.println(sum[goal]);
    }
}
