package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2631_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //최장 증가 수열
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] lis = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = i - 1; 0 <= j; j--) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            max = Math.max(lis[i], max);
        }
        System.out.println(n - max);

    }
}
