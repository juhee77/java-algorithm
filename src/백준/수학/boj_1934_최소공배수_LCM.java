package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1934_최소공배수_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a * b / gcd(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
