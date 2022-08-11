package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1740_거듭제곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long goal = Long.parseLong(br.readLine());
        long ans = 0;
        long now = 1;
        String s = Long.toBinaryString(goal);
        StringBuffer sb = new StringBuffer(s);
        String revers = sb.reverse().toString();

        //System.out.println(s);
        while(true){
            if(revers.length()<1) break;
            ans += Integer.parseInt(revers.substring(0,1))*now;
            now *=3;
            revers = revers.substring(1);
        }
        System.out.println(ans);
    }
}
