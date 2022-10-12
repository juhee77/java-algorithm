package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1208_부분수열의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int arr[] = new int[numberCount + 1];
        int sum[] = new int[numberCount + 1];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= numberCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
            //누적합 i 번 까지의 모든 수의 합
            // 이걸 이용하여 end 까지의 합에서 start 전까지의 합을 더함
            for (int j = 0; j <= i - 1; j++) {
                if (sum[i] - sum[j] == goal) {
                    System.out.println(i+" "+j+" "+sum[i]+" "+sum[j]);
                    cnt++;
                }
            }
        }


        System.out.println(cnt);

    }
}
