package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3460_이진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            while (1 <= n) {
                if (n % 2 == 1) sb.append(cnt).append(" ");
                n /= 2;
                cnt++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
