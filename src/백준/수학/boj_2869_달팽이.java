package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2869_달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long plus = Integer.parseInt(st.nextToken());
        long minus = Integer.parseInt(st.nextToken());
        long height = Integer.parseInt(st.nextToken());

        long onday = plus - minus;
        if((height-plus)%onday==0){
            System.out.println(((height-plus)/onday)+1);
        }
        else{
            System.out.println((height-plus)/onday+2);
        }
    }
}
