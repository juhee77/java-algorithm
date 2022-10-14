package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj_1644_소수합 {

    private static void checkprime(int n) {
        boolean prime[] = new boolean[n + 1];
        prime[0] = prime[1] = true;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) { //제곱근 만큼 돌아도 계산 가능
            if (prime[i]) continue;
            for (int j = i * i; j < n + 1; j += i) prime[j] = true; //에라토스 테네스의 체 사용
        }
        int cnt = 0;

        ArrayList<Integer> plist = new ArrayList<>();

        for (int i = 1; i < n + 1; i++)
            if (!prime[i]) plist.add(i);


        Integer[] pr = plist.toArray(new Integer[0]);
        int left = 0, right = 0;
        int sum = 0;
        while (right < pr.length) {
            if (pr[right] + sum > n) sum -= pr[left++];
            else if (pr[right] + sum <= n) {
                if (pr[right] + sum == n) cnt++;
                sum += pr[right++];
            }
        }

        System.out.println(cnt);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        checkprime(n);

    }
}
