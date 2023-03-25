package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 밀러_라빈소수 {
    // https://casterian.net/algo/miller-rabin.html#sec2-1
    public static long[] prime = {2, 325, 9375, 28178, 450775, 9780504, 1795265022};
    public static final String NO = "NO";
    public static final String YES = "YES";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            sb.append(solution(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static String solution(long a, long b) {
        long sum = a + b;
        if (sum < 2) return NO;

        //두수의 합이 홀수이면 2(소수)+ sum-2(소수)의 꼴로 나타내야만 가능함
        if (sum%2==1) {
            if (isPrime(sum - 2)) {
                return YES;
            }
            return NO;
        }
        //두수의 합이 짝수인 경우 골드 바흐의 추측에 의해 두수의 합이 2이상의 짝수이면 모두 소수로 표현 가능하다.
        return YES;
    }

    private static boolean isPrime(long n) {
        if (n == 1) return false;

        if (n <= 10000000000L) {
            for(int i=2;i<Math.sqrt(n)+1;i++){ //제곱근 만큼 돌아도 계산 가능
                if(i!=n && n%i==0) return false;
            }
            return true;
        }

        for (long nowPrime : prime) {
            if(n==nowPrime) return true;
            if(!millerRabin(n,nowPrime)) return false;
        }
        return true;
    }

    private static long pow(long x, long y, long mod) {
        long result =1;
        x %= mod;
        while (y >= 1) {
            if(y%2>=1) result = (result + x) % mod;
            y/=2;
            x = (x * x) % mod;
        }
        return result;
    }
    private static boolean millerRabin(long n, long p) {
        long now = n - 1;
        while (now % 2 == 0) {
            if (pow(p, now, n) == n - 1) {
                return true;
            }
            now /= 2;
        }
        long temp = pow(p, now, n);
        return temp == n - 1 || temp == 1;
    }
}




