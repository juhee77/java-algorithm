package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2156{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        long arr[][] = new long[line +1][3];

        for(int i = 1; i<= line; i++){
            int temp = Integer.parseInt(br.readLine());
            arr[i][2]= Math.max(Math.max(arr[i-1][1]+temp,arr[i-1][0]+temp),arr[i-1][2]);
            arr[i][1]= arr[i -1][0]+temp;
            arr[i][0] = arr[i -1][2];
            System.out.println(temp+ Arrays.toString(arr[i]));
        }
        sb.append(Math.max(arr[line][0],Math.max(arr[line][1],arr[line][2])));
        System.out.println(sb);
    }
}
