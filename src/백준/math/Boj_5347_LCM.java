package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5347_LCM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(lcm(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    //유클리드 호제법(최대공약수)
    private static int gcd(int n, int m) {
        if (m == 0) return n;
        else return gcd(m, n % m);
    }

    //유클리드 호제번 (최대공배수)
    private static long lcm(int n, int m) {
        return ((long) n * m) / gcd(n, m);
    }
}
