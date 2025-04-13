package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj_1153_네개의소수 {
    private static List<Integer> primes = new ArrayList<>();
    private static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N < 8) {
            System.out.println("-1");
            return;
        }

        findPrimes(N);
        List<Integer> path = new ArrayList<>();
//      골드바흐의 추측 ( 짝수는 항상 두 소수의 합으로 표현이 가능하다 => 짝수가 되면 찾을수 있음)
        if (N % 2 == 0) {
            path.add(2);
            path.add(2);
            N -= 4;
        } else {
            path.add(2);
            path.add(3);
            N -= 5;
        }
        for (int prime : primes) {
            int other = N - prime;
            if (other >= 2 && isPrime[other]) {
                path.add(prime);
                path.add(other);
                break;
            }
        }

        for (int num : path) {
            System.out.print(num + " ");
        }
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

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }
}
