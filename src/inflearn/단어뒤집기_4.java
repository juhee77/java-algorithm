package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 단어뒤집기_4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<line;i++){
            StringBuffer temp = new StringBuffer(br.readLine());
            sb.append(temp.reverse().toString()).append('\n');
        }
        System.out.println(sb);
    }
}
