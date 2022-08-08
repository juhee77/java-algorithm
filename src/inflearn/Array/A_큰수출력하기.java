package inflearn.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A_큰수출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int before = Integer.parseInt(st.nextToken());
        sb.append(before+" ");
        for(int i=1;i<line;i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp>before) sb.append(temp+" ");
            before = temp;
        }
        System.out.println(sb);
    }
}
