package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5525_I0I0I0I0I0 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int cnt = 0;
        int pattern = 0;

        for (int i = 0; i < num-2 ; i++) {
            if(s.charAt(i)=='I' && s.charAt(i+1)=='O' && s.charAt(i+2)=='I'){
                pattern++;
                if(pattern==n){
                    pattern--;
                    cnt++;
                }
                i++;
            }
            else pattern=0;
        }

        System.out.println(cnt);
    }
}
