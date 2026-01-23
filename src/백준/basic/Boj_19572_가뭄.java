package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_19572_가뭄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int x3 = Integer.parseInt(st.nextToken());

        double b = x1;
        double c = x2;
        double a = (-x3 + b + c) / 2.0;
        b = x1 - a;
        c = x2 - a;

        if (a > 0 && b > 0 && c > 0) {
            sb.append("1\n");
            sb.append(getOneRound(a) + " " + getOneRound(b) + " " + getOneRound(c));
        } else {
            sb.append("-1");
        }
        System.out.println(sb);

    }

    private static double getOneRound(double a) {
        return (double) Math.round(a * 10) / 10;
    }
}
