package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_14626_ISBN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String isbn = br.readLine();
        int starIndex = isbn.indexOf('*');
        int[] weights = new int[13];
        for (int i = 0; i < 13; i++) {
            weights[i] = (i % 2 == 0) ? 1 : 3;
        }

        for (int digit = 0; digit <= 9; digit++) {
            int sum = 0;
            for (int i = 0; i < 13; i++) {
                int val;
                if (i == starIndex) {
                    val = digit;
                } else {
                    val = isbn.charAt(i) - '0';
                }
                sum += val * weights[i];
            }

            if (sum % 10 == 0) {
                System.out.println(digit);
                break;
            }
        }
    }
}
