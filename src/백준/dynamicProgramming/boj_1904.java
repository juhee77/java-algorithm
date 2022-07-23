package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        int arr[] = new int[input];
        arr[0]=1;
        if(input>=2)arr[1]=2;
        for(int i=2;i<input;i++){
            arr[i] =(arr[i-1]+arr[i-2])%15746;
        }
        sb.append(arr[input -1 ]);

        System.out.println(sb);

    }
}
