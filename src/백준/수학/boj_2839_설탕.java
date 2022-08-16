package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2839_설탕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int goal = Integer.parseInt(br.readLine());

        int fiMax= goal/5;
        int thMax = goal/3;
        int flag = -1;

        for(int i=fiMax; 0<=i; i--) {
            for(int j=0;j<=thMax;j++){
                if(i*5 + j*3 == goal){
                    flag = i+j;
                    break;
                }
            }
            if(flag != -1 )break;
        }

        System.out.println(flag);
    }
}
