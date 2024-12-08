package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_7570_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int numberCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[numberCount+1];
        int[] sum = new int[numberCount+1];

        for (int i = 1; i < numberCount+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0; // 최장 증가 연속 부분 수열의 길이
        for (int i = 1; i < numberCount+1; i++) {
            sum[arr[i]] = sum[arr[i] - 1] + 1;
            maxLength = Math.max(maxLength, sum[arr[i]]);
        }

        System.out.println(numberCount - maxLength);
    }
}
