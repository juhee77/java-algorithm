package 백준.dynamicProgramming.가장긴증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int numberCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[numberCount];
        int sum[] = new int[numberCount];
        int sum2[] = new int[numberCount];


        for(int i=0;i<numberCount;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<numberCount;i++){
            sum[i]=1;
            for(int j=0;j<i;j++)
                if(arr[i]>arr[j] && sum[i]<=sum[j])sum[i] = sum[j]+1;
//            System.out.println(Arrays.toString(sum));
        }

        for(int i=numberCount-1;0<=i;i--){
            sum2[i]=1;
            for(int j=numberCount-1;i<j;j--)
                if(arr[i]>arr[j] && sum2[i]<=sum2[j])sum2[i] = sum2[j]+1;
//            System.out.println(Arrays.toString(sum2));
        }

        int max = 0;
        for(int i=0;i<numberCount;i++)
            max = Math.max(sum[i]+sum2[i]-1,max);

        System.out.println(max);

    }
}
