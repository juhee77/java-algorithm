package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_6588_골드바흐의추측 {
    public static final int MAX = 1000000;
    private static int[] isPrime = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        initPrime();
        int n;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            for (int i = 3; i <= n / 2; i += 2) //두 홀수의 합으로 이루어져야한다.
            {
                if (isPrime[i] == 0 && isPrime[n - i] == 0) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static void initPrime() {
        isPrime[0] = isPrime[1] = 1;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i] == 0) {
                for (int j = i * 2; j <= MAX; j += i) {
                    isPrime[j] = 1;
                }
            }
        }
    }
}