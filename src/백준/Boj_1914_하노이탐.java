package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_1914_하노이탐 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n <= 20) {
            sb.append((1 << n) - 1).append("\n");
            hanoi(1, 3, n, 2);
        } else {
            BigInteger bigInteger = BigInteger.TWO.pow(n).subtract(BigInteger.ONE);
            sb.append(bigInteger);
        }
        System.out.println(sb);
    }

    private static void hanoi(int start, int end, int cnt, int between) {
        if (cnt == 1) {
            sb.append(start + " " + end).append("\n");
            return;
        }
        //나머지를 옮긴다
        if (cnt >= 1) hanoi(start, between, cnt - 1, end);
        //원판 하나를 옮긴다.
        sb.append(start + " " + end).append("\n");
        //나머지를 다시 그 위로 올린다.
        if (cnt >= 1) hanoi(between, end, cnt - 1, start);
    }
}
