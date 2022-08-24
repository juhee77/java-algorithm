package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5086_배수약수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            if(L==0 && R==0) break;

            if(R%L==0)sb.append("factor").append('\n');
            else if (L%R==0) sb.append("multiple").append('\n');
            else sb.append("neither").append('\n');
        }
        System.out.println(sb);
    }
}
