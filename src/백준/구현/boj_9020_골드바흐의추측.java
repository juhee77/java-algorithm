package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_9020_골드바흐의추측 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        //prime
        boolean[] prime = makePrime(10000);
        while (tc-- > 0) {
            int now = Integer.parseInt(br.readLine());
            sb.append(findAns(now, prime)).append("\n");
        }
        System.out.println(sb);
    }

    private static String findAns(int now, boolean[] prime) {
        for (int i = now / 2; i <= now; i++) {
            if (prime[i] && prime[now - i]) {
                return now - i + " " + i;
            }
        }
        throw new IllegalArgumentException();
    }

    private static boolean[] makePrime(int num) {
        boolean[] prime = new boolean[num + 1];
        Arrays.fill(prime, true);
        for (int i = 2; i <= num; i++) {
            if (prime[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}
