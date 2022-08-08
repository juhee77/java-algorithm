package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726_2N타일링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n+1];
        arr[1]=1;

        if (n >= 2) {
            arr[2]=2;
            for(int i=3;i<n+1;i++)
                arr[i] = arr[i-1]+arr[i-2];

        }

        System.out.println(arr[n]%10007);
    }
}
