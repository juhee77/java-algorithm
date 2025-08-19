package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_6219_소수의자격 {
    public static final int MAX = 4_000_001;
    private static final boolean[] isNotPrime = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String c = st.nextToken();


        setPrime(b);
        int cnt = 0;
        for (int i = a; i <= b; i++) {
            if (!isNotPrime[i]) {
                String s = String.valueOf(i);
//                System.out.println(s);
                if(s.contains(c)) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void setPrime(int max) {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= max; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j <= max; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
    }
}

