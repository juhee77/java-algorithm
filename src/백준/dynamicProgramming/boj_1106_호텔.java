package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1106_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int goal = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());
        int arr[][] = new int[city][2];
        int sum[] = new int[goal + 1];

        for (int i = 0; i < city; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            //0 비용, 1 가격
        }

        Arrays.fill(sum, (int) 1e8);
        sum[0] = 0;
        for (int i = 1; i <= goal; i++) {
            for (int j = 0; j < city; j++) {
                int temp = i / arr[j][1] * arr[j][0];
                sum[i] = Math.min(sum[i], (i % arr[j][1] == 0) ? temp : temp + arr[j][0]);
                if (i >= arr[j][1]) sum[i] = Math.min(sum[i], sum[i - arr[j][1]] + arr[j][0]);
            }
        }

        //System.out.println(Arrays.toString(sum));
        System.out.println(sum[goal]);
    }
}
