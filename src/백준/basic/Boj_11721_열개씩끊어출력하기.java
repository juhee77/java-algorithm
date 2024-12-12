package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11721_열개씩끊어출력하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int hold = 0;
        while (s.length() > hold) {
            sb.append(s.substring(hold, Math.min(s.length(), hold + 10))).append("\n");
            hold += 10;
        }
        System.out.println(sb);

    }
}
