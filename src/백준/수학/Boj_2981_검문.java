package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_2981_검문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, arr[i] - arr[i - 1]);
        }

        for (int j = 2; j <= gcd; j++) {
            if (gcd % j == 0) {
                sb.append(j).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
