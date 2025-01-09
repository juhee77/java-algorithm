package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2089_2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int remainder = n % -2;
            n /= -2;

            if (remainder < 0) {
                remainder += 2;
                n += 1;
            }

            sb.append(remainder);
        }
        System.out.println(sb.reverse());
    }
}
