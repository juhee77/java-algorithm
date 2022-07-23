package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        int tempSum=Integer.parseInt(st.nextToken());
        int max=tempSum;

        for(int i=1;i<n;i++){
            int temp=Integer.parseInt(st.nextToken());

            tempSum=Math.max(tempSum+temp,temp);
            max=Math.max(max,tempSum);
        }
        System.out.println(max);

/*
        int arr[]=new int[n];
        arr[0]=Integer.parseInt(st.nextToken());
        int max=arr[0];
        for(int i=1;i<n;i++){
            int temp=Integer.parseInt(st.nextToken());
            arr[i]=Math.max(arr[i-1]+temp,temp);
            max=Math.max(arr[i],max);
        }
        System.out.println(max);*/
    }
}
