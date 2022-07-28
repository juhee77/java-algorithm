package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2293_coin1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int arr[] = new int[line + 1];
        int sum[] = new int[goal + 1];

        for (int i = 1; i <= line; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        //System.out.println(Arrays.toString(arr));

        sum[0] = 1;
        for(int i=1;i<=line;i++){
            for(int j=arr[i];j<=goal;j++){
                sum[j] = sum[j] + sum[j-arr[i]];
            }
        }
        sb.append(sum[goal]);
        System.out.println(sb);
    }
}
