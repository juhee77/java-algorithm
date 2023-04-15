package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2302_극장좌석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //주어진 조건을 만족하면서 사람들이 좌석에 앉을 수 있는 방법의 가짓수를 출력한다.
        //첫째 줄에는 좌석 개수 n개 , 둘째 줄에는 고정석의 M이 입력된다.
        //이후에는 고정석의 번호가 작은 수부터 큰 수의 순서로 한줄에 하나씩 입려된다.
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int sum = 1;

        int[] dp = new int[n + 1];
        dp[1] = dp[0] = 1;
        if (n >= 2) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int idx = 0;
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(br.readLine());
            sum *= dp[temp - idx - 1];
            idx = temp;
        }
        sum *= dp[n - idx];
        System.out.println(sum);

    }
}
