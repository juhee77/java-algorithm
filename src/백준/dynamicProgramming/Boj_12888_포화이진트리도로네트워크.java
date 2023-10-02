package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_12888_포화이진트리도로네트워크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n <= 2) {
            if (n <= 1) {
                System.out.println(1);
            } else System.out.println(3);
        } else {
            long before = 3;
            for (int i = 2; i < n; i++) {
                if (i % 2 == 1) {
                    before = before * 2 + 1;
                } else {
                    before = before * 2 - 1;
                }
            }
            System.out.println(before);
        }
    }
}
