package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int lcm = lcm(a2, b2);
        int sum = lcm / a2 * a1 + lcm / b2 * b1;

        int gcd = gcd(sum, lcm);
        System.out.println(sum / gcd + " " + lcm / gcd);
    }

    //유클리드 호제법(최대공약수)
    private static int gcd(int n, int m) {
        if (m == 0) return n;
        else return gcd(m, n % m);
    }

    //유클리드 호제번 (최대공배수)
    private static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

}
