package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10986_나머지합F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int cnt = Integer.parseInt(st.nextToken());
        int divisor = Integer.parseInt(st.nextToken());

        int before = 0;
        int remainder[] = new int[divisor];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            before = (before+Integer.parseInt(st.nextToken()))%divisor;
            remainder[before]++;
        }

        long ans = remainder[0]; // 나머지가 0인 경우는 그 자체로 만족되는 경우 (long 타입 선언 하지 않으면 -> 런타임 에러 or 오버플로우 남)
        for (int i = 0; i < divisor; i++) {
            ans += (long)remainder[i] * (remainder[i] - 1) / 2; // 나머지에 맞춰서 제거하면 정확하게 나누어짐
        }
        sb.append(ans);
        System.out.println(sb);

    }
}

