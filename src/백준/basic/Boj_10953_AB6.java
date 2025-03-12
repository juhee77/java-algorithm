package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10953_AB6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] s = br.readLine().split(",");
            sb.append(Integer.parseInt(s[0]) + Integer.parseInt(s[1])).append("\n");
        }
        System.out.println(sb);
    }
}
