package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s=br.readLine();

        HashSet<String> hash = new HashSet<String>();

        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String temp = s.substring(i,j);
                if(hash.contains(temp)) continue;
                else{
                    hash.add(temp);
                }
            }
        }

        sb.append(hash.size());
        System.out.println(sb);
    }
}
