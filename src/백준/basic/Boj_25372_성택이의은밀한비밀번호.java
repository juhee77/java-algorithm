package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_25372_성택이의은밀한비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int length = br.readLine().length();
            if(6<=length && length<=9) sb.append("yes");
            else sb.append("no");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
