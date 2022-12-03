package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1094_막대기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        //ex) 64 100000 & 1 = false , 101&1 = true , 1&1 = true, 왼쪽 부터 앞으로 비교해가면 서 더한다.
        while(X>0){
            if((X&1)==1){
                cnt++;
            }
            X>>=1;
        }
        System.out.println(cnt);
    }
}
