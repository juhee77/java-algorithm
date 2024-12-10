package 백준.regx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2857_FBI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            if (s.matches("[/A-Z,0-9,-]+") && s.length() <= 10 && s.contains("FBI")) {
                cnt++;
                sb.append(i + 1).append(" ");
            }
        }
        if (cnt == 0) sb.append("HE GOT AWAY!");
        System.out.println(sb);
    }
}
