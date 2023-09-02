package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1016_제곱ㄴㄴ수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long count = max - min + 1;
        boolean[] check = new boolean[(int) count];


        for (long i = 2; i * i <= max; i++) {
            long temp = i * i;
            long start = 0;

            if (min % temp == 0) { //모듈러 연산 나머지에 대해서 확인 
                start = min / temp;
            } else {
                start = (min / temp) + 1;
            }

            for (long j = start; j * temp <= max; j++) {
                int diff = (int) ((j * temp) - min);
                if (!check[diff]) {
                    check[diff] = true; // 나누어 떨어지는 수 범위 초과로 -s 해서 저장
                    count--;
                }
            }
        }
        System.out.println(count);
    }

}
