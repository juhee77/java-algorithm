package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3036_링 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int init = Integer.parseInt(st.nextToken());
        for (int i = 1; i < cnt; i++) {
            int a = Integer.parseInt(st.nextToken());

            int lcm = gcd(a, init);
            sb.append(init / lcm).append("/").append(a / lcm).append("\n");

        }
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
