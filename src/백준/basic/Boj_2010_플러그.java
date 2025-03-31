package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2010_플러그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int now = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += (now - 1);
            now = Integer.parseInt(br.readLine());
        }
        System.out.println(ans + now);
    }
}
