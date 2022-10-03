package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2294_동전2 {
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

        Arrays.fill(sum,(int)1e9);
        sum[0] = 0;
        for(int i=0;i<=goal;i++){
            for(int j=1;j<=line;j++){
                if(arr[j]<=i)sum[i] = Math.min(sum[i],sum[i-arr[j]] +1);
            }
        }

        //System.out.println(Arrays.toString(sum));
        sb.append((sum[goal]==(int)1e9)?-1:sum[goal]);
        System.out.println(sb);
    }
}
