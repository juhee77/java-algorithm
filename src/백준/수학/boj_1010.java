package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        for(int i=0;i<line;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            double cnt =1 ;

            for(int p=1;p<=x;p++){
                cnt=cnt*(y--)/p;
            }

            sb.append((int)cnt).append('\n');
        }
        System.out.println(sb);
    }
}
