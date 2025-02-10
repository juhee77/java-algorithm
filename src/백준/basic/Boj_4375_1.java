package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Boj_4375_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp;
        while (true) {
            temp = br.readLine();
            if (temp == null || temp.length() == 0) break;
            BigInteger parseInt = new BigInteger(temp, 10);
            BigInteger tempInt = BigInteger.ONE;
            while (!tempInt.mod(parseInt).equals(BigInteger.ZERO)) {
                tempInt = tempInt.multiply(BigInteger.TEN).add(BigInteger.ONE);
            }
            sb.append(tempInt.toString().length()).append("\n");
        }
        System.out.println(sb);
    }
}
