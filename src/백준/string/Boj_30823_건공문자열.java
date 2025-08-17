package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_30823_건공문자열 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        k--;

        sb.append(input.substring(k));
        if ((n-k) % 2 == 0) {
            sb.append(input.substring(0, k));
        } else {
            sb.append(new StringBuilder(input.substring(0, k)).reverse());
        }
        System.out.println(sb.toString());
    }
}
