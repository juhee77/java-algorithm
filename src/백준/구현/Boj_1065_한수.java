package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1065_한수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 100) cnt++;
            else {
                int a1 = i % 10;
                int a2 = i / 10 % 10;
                int a3 = i / 100;

                if (a3 - a2 == a2 - a1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
