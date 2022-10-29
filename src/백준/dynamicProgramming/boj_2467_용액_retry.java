package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2467_용액_retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int arr[] = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) arr[i] = Integer.parseInt(st.nextToken());

        int left = 0, right = input-1;

        int idx1=arr[left],idx2=arr[right];
        int min =Math.abs(idx1+idx2);

        while(left < right){
            int temp = arr[left]+arr[right];
            if(Math.abs(temp) < min){
                min= Math.abs(temp);
                idx1 = arr[left];
                idx2 = arr[right];
            }

            if(temp<0) left++;
            else right--;

        }

        System.out.println(idx1 + " "+idx2);
    }
}
