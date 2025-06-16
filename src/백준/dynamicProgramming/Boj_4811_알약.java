package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_4811_알약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger[] catalan = new BigInteger[31];
        catalan[0] = BigInteger.ONE;
        int nowHold = 0;

        int input;
        while ((input = Integer.parseInt(br.readLine())) != 0) {
            if (nowHold < input) {
                for (int i = 1; i <= input; i++) {
                    catalan[i] = BigInteger.ZERO;
                    for (int j = 0; j < i; j++) {
                        catalan[i] = catalan[i].add(catalan[j].multiply(catalan[i - 1 - j]));
                    }
                }
                nowHold = input;
            }
            sb.append(catalan[input]).append("\n");
        }
        System.out.println(sb);
    }
}
