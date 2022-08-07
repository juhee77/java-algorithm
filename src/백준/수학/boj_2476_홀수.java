package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2476_홀수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int sum =0;
        for(int i=0;i<7;i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp%2 == 1) {
                sum+= temp;
                min = Math.min(min,temp);
            }
        }
        if(sum == 0) System.out.println(-1);
        else System.out.println(sum+"\n"+min);
    }
}
