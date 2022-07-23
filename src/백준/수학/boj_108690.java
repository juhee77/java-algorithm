package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_108690 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())).append('\n');
        }
        System.out.println(sb);

    }
}
