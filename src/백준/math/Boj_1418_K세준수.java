package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1418_K세준수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[n + 1];
        boolean[] reverse = new boolean[n + 1];
        int notKSejun = 0;
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < n + 1; i++) {
            if (!isNotPrime[i]) {
                if (i > k) {
                    reverse[i] = true;
                    notKSejun++;
                }

                for (int j = i + i; j <= n; j += i) {
                    isNotPrime[j] = true;
                    if (i > k && !reverse[j]) {
                        notKSejun++;
                        reverse[j] = true;
                    }
                }
            }
        }
        System.out.println(n - notKSejun);
    }
}
