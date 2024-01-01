package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1543_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String find =  br.readLine();
        int cnt = 0;
        int idx;
        while ((idx = str.indexOf(find))!=-1) {
            cnt++;
            str = str.substring(idx+find.length());
        }
        System.out.println(cnt);
    }
}
