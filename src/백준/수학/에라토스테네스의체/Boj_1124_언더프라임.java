package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1124_언더프라임 {
    public static final int MAX = 100_001;
    private static final boolean[] isNotPrime = new boolean[MAX];
    private static final int[] primes = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        setPrime();
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (!isNotPrime[primes[i]]) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static void setPrime() {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < MAX; i++) {

            if (!isNotPrime[i]) {
                for (int j = i + i; j < MAX; j += i) {
                    isNotPrime[j] = true;
                    int temp = j;
                    while (temp % i == 0) {
                        primes[j]++;
                        temp /= i;
                    }
                }
            }
        }
    }
}

