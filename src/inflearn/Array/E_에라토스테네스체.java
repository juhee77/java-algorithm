package inflearn.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_에라토스테네스체 {
    public static int solution1(int n) { //런타임 에러 나는경우 sqrt +1 or 자료형 바꾸기!!!!
        int prime[] = new int[n + 1];
        prime[0] = prime[1] = 1;
        int cnt = 0;//2

        for (int i = 2; i < Math.sqrt(n) + 1; i++) { //제곱근 만큼 돌아도 계산 가능
            if (prime[i] == 1) continue;
            for (int j = i * i; j < n + 1; j += i) prime[j] = 1; //에라토스 테네스의 체 사용
        }

        for (int i = 1; i < n + 1; i++)
            if (prime[i] == 0) cnt++;

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution1(num));

    }
}
