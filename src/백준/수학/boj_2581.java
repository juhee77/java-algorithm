package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2581 {

    private static int prime[];


    private static void solution(int n, int x) { //런타임 에러 나는경우 sqrt +1 or 자료형 바꾸기!!!!
        prime[0] = prime[1] = 1;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) { //제곱근 만큼 돌아도 계산 가능
            if (prime[i] == 1) continue;
            for (int j = i * i; j < n + 1; j += i) prime[j] = 1; //에라토스 테네스의 체 사용
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        prime = new int[y + 1];

        solution(y,x);

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = x; i < y+ 1; i++)
            if (prime[i] == 0) {
                min = Math.min(min,i);
                sum+= i;
            }

        if(sum==0)System.out.println(-1);
        else System.out.println(sum+"\n"+min);
    }
}
