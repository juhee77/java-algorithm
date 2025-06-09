package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1456_거의소수 {
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int sqrtB = (int) Math.sqrt(b);
        findPrimes(sqrtB);

        int count = 0;
        for (int i = 2; i <= sqrtB; i++) {
            if (isPrime[i]) {
                long next = (long) i * i;
                while (next <= b) {
                    if (next >= a) {
                        count++;
                    }
                    if (next > b / i) break;
                    next *= i;
                }
            }
        }
        System.out.println(count);
    }

    private static void findPrimes(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
