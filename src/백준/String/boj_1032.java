package 백준.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine()) - 1;
        char[] ans = br.readLine().toCharArray();
        while (line-- > 0) {
            char[] temp = br.readLine().toCharArray();
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] != temp[i]) {
                    ans[i] = '?';
                }
            }
        }
        System.out.println(String.valueOf(ans));
    }
}
