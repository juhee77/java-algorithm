package 백준.dynamicProgramming.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10986_나머지합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = Integer.parseInt(st.nextToken());
        int divisor = Integer.parseInt(st.nextToken());

        int before = 0;
        int[] remainder = new int[divisor];


        //모듈러 연산을 고려한다.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            before = (before + Integer.parseInt(st.nextToken())) % divisor;
            remainder[before]++;
        }


        //각 모듈러의 해당하는 값
        /*
          i~j 까지으 부분함 sum[j]-sum[i-1]
          이게 나눠지는지 아는 방법은
          sum[j]mod X == sum[i-1] mod X 이여야 한다
          따라서 remainder에 남은 숫자들중 nC2(n개중 두개를 선택하는 방법)으로 계산한다.
          그러면 이는
          나머지가 1이 나오는 두가지를 선택하면  j mod X(1)- i mod X(1)이여서 0으로 나눠지는경우이기 때문이다.
         */
        long ans = remainder[0]; // 나머지가 0인 경우는 그 자체로 만족되는 경우 (long 타입 선언 하지 않으면 -> 런타임 에러 or 오버플로우 남)
        for (int i = 0; i < divisor; i++) {
            ans += (long) remainder[i] * (remainder[i] - 1) / 2; // 나머지에 맞춰서 제거하면 정확하게 나누어짐
        }
        sb.append(ans);
        System.out.println(sb);

    }
}

