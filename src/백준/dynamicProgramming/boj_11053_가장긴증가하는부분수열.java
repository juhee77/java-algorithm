package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int numberCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[numberCount];
        int sum[] = new int[numberCount];

        for(int i=0;i<numberCount;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //sum[numberCount][numberCount]=1;
        for(int i=0;i<numberCount;i++){
            sum[i]=1;
            for(int j=0;j<i;j++)
                if(arr[i]>arr[j] && sum[i]<=sum[j])sum[i] = sum[j]+1;
            System.out.println(Arrays.toString(sum));

        }
        int max = 0;
        for(int i=0;i<numberCount;i++)
            max = Math.max(sum[i],max);

        System.out.println(max);

    }
}
