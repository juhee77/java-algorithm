package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11094_꿍가라사대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(line-->0){
            String temp = br.readLine();
            if(temp.length()>10 && temp.startsWith("Simon says")){
                sb.append(temp.substring(10)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
