package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int day = Integer.parseInt(br.readLine());

            long[] arr = new long[day];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < day; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long max = 0;
            long sum = 0;
            for (int i = day - 1; 0 <= i; i--) {
                if (max > arr[i]) {
                    sum += max - arr[i];
                } else {
                    max = arr[i];
                }
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
