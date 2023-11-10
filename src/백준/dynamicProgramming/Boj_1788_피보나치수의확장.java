package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1788_피보나치수의확장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 0) {
            System.out.println(0);
            System.out.println(0);
        } else {
            int absN = Math.abs(n);
            int[] arr = new int[Math.max(absN + 1, 3)];
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 2; i <= absN; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 1_000_000_000;
            }

            if (n % 2 == 0 && n <= 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
            System.out.println(arr[absN]);
        }
    }
}