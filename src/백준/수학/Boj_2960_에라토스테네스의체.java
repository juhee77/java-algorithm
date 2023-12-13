package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2960_에라토스테네스의체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(getRank(n, k));

    }

    private static int getRank(int n, int k) {
        boolean[] isNotPrime = new boolean[n + 1];
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                if (!isNotPrime[j]) {
                    isNotPrime[j] = true;
                    cnt++;
                    if (cnt == k) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }
}
