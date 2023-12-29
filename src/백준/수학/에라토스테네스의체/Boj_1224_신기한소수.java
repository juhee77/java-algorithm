package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1224_신기한소수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int MAX = (int) Math.pow(10, n);

        for (int i = (int) Math.pow(10, n - 1); i < MAX; i++) {
            if (checkIsPrime(i)) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean checkIsPrime(int temp) {
        if (temp ==0) return true;
        if (checkIsPrime(temp / 10)) {
            return checkPrime(temp);
        }
        return false;//이미 불가능함
    }

    public static boolean checkPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) { //제곱근 만큼 돌아도 계산 가능
            if (i != n && n % i == 0) {
                return false;
            }
        }

        return true;
    }
}

//이 방법 외의 2,3,5,7을 시작으로 해당 숫자로 부터 시작하게하여 dfs하는 방법도 존재한다.
