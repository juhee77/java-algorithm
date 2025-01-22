package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_16565_N포커 {
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countWins(n));
    }

    public static int countWins(int N) {
        if (N < 4) {
            return 0; // N < 4일 때 포카드 불가능
        }

        if (N == 52) {
            return 1; // N=52일 때는 항상 포카드가 포함됨
        }

        // 포카드가 포함된 경우의 수
        int singlePokerCases = (13 * comb(48, N - 4)) % MOD;

        // 포카드가 2쌍 이상 포함된 경우의 수
        int doublePokerCases = 0;
        if (N >= 8) {
            doublePokerCases = (comb(13, 2) * comb(44, N - 8)) % MOD;
        }

        // 포함-배제 원리 적용
        int winningCases = (singlePokerCases - doublePokerCases) % MOD;
        if (winningCases < 0) {
            winningCases += MOD; // 음수 방지
        }

        return winningCases;
    }

    // 조합 계산 함수: nCr % MOD
    public static int comb(int n, int r) {
        if (r > n || r < 0) {
            return 0; // 조합이 성립하지 않는 경우
        }
        return (factorial(n) * modInverse(factorial(r)) % MOD * modInverse(factorial(n - r)) % MOD) % MOD;
    }

    // 팩토리얼 계산 (모듈로 연산 포함)
    public static int factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result = (result * i) % MOD;
        }
        return (int) result;
    }

    // 모듈러 역원 계산 (페르마의 소정리 사용)
    public static int modInverse(int x) {
        return power(x, MOD - 2);
    }

    // 거듭 제곱 계산: (x^y) % MOD
    public static int power(int x, int y) {
        long result = 1;
        long base = x;

        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            y /= 2;
        }

        return (int) result;
    }
}
