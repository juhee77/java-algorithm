package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_2312_수복원하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, input[i]);
        }

        List<Integer> primes = getPrimes(max);
        for (int i = 0; i < n; i++) {
            int now = input[i];
            int[] hold = new int[primes.size()];
            while (now > 1) {
                for (int j = 0; j < primes.size(); j++) {
                    if (now % primes.get(j) == 0) {
                        hold[j]++;
                        now /= primes.get(j);
                        break;
                    }
                }
            }
            for (int j = 0; j < hold.length; j++) {
                if (hold[j] > 0)
                    sb.append(primes.get(j)).append(" ").append(hold[j]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static List<Integer> getPrimes(int max) {
        boolean[] isNotPrime = new boolean[max + 1];
        List<Integer> primes = new ArrayList<>();
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < max + 1; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
                for (int j = i + i; j <= max; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        return primes;
    }
}
