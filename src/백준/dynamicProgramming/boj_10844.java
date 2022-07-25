package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        long arr[][] = new long[n + 1][11];


        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                for (int j = 0; j <= 9; j++) {
                    arr[i][j] = 1;
                }
            } else {
                arr[i][0] = (arr[i - 1][1]) % 1000000000;
                for (int j = 1; j <= 9; j++) {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for (int j = 1; j <= 9; j++) {
            sum += arr[n][j] % 1000000000;
            sum%=1000000000;
        }
        System.out.println(sum);
    }
}
