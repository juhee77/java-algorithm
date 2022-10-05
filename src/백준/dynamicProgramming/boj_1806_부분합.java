package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806_부분합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        st= new StringTokenizer(br.readLine());
        int ans =Integer.MAX_VALUE;

        int left =0;
        int right = 0;
        long sum =0;
        int arr[] = new int[line];


        for(int i=0;i<line;i++)arr[i] = Integer.parseInt(st.nextToken());
        while(right<line){
            if(arr[right]>=goal) {
                ans = 1;
                break;
            }

            if(sum + arr[right] >= goal ){
                sum -= arr[left];
                ans = Math.min(right-left+1,ans);
                left++;
            }
            else sum += arr[right++];

        }

        if(ans ==Integer.MAX_VALUE)ans = 0;
        System.out.println(ans);

    }
}
