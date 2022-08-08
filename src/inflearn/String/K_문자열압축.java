package inflearn.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class K_문자열압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String ans = br.readLine();
        String last =ans.substring(0,1);
        int lastcnt = 1;

        for(int i=1;i<ans.length();i++){
            if(ans.substring(i,i+1).equals(last)) lastcnt++;
            else {
                if(lastcnt>=2)sb.append(last+String.valueOf(lastcnt));
                else sb.append(last);
                last = ans.substring(i,i+1);
                lastcnt = 1;
            }
        }
        if(lastcnt>=2)sb.append(last+String.valueOf(lastcnt));
        else sb.append(last);
        System.out.println(sb);
    }
}
