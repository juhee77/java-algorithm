package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_6810_ISBN {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] csCase = {1, 3};
        int[] code = new int[13];

        int[] firstTenDigits = {9, 7, 8, 0, 9, 2, 1, 4, 1, 8};

        System.arraycopy(firstTenDigits, 0, code, 0, 10);

        for (int i = 10; i < 13; i++) {
            code[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        for (int i = 0; i < code.length; i++) {
            sum += code[i] * csCase[i % 2];
        }

        System.out.println("The 1-3-sum is " + sum);
    }

}