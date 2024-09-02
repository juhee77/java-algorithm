package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_7567_그릇 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chars = br.readLine().toCharArray();
        char before = chars[0];
        int ans = 10;
        for (int i = 1; i < chars.length; i++) {
            if (before == chars[i]) {
                ans += 5;
            } else {
                ans += 10;
                before = chars[i];
            }
        }
        System.out.println(ans);
    }
}
