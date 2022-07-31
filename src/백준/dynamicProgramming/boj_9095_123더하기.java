package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095_123더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        int arr[] = new int[12];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        arr[3]=4;
        for(int i=4;i<=11;i++){
            arr[i]=arr[i-1]+arr[i-2]+arr[i-3];
        }

        for(int tc=0;tc<TC;tc++){
            int temp = Integer.parseInt(br.readLine());
            sb.append(arr[temp]).append('\n');
        }
        System.out.println(sb);
    }
}
