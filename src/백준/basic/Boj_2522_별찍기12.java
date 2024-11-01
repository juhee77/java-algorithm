package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2522_별찍기12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i < n; i++) {
            sb.append(" ".repeat(n - i));
            sb.append("*".repeat(i));
            sb.append("\n");
        }
        for (int i = 0; i < n; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat(n - i));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
