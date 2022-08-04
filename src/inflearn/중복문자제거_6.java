package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 중복문자제거_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> hash = new HashSet<String>();
        String ans = br.readLine();
        for(int i=0;i<ans.length();i++){
            if(!hash.contains(ans.substring(i,i+1))) {
                hash.add(ans.substring(i,i+1));
                sb.append(ans.substring(i,i+1));
            }
        }
        System.out.println(sb);
    }
}
