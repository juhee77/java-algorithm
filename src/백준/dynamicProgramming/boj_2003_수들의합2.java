package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //숫자의 개수
        int m = Integer.parseInt(st.nextToken()); //목표 합
        long[] subSum = new long[n + 1]; //부분합 저장
        int startIdx = 0; //시작 위치

        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(st.nextToken());
            subSum[i] = subSum[i - 1] + now;

            while (m < subSum[i] - subSum[startIdx]) {
                startIdx++;
            }

            if (m == subSum[i] - subSum[startIdx]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}