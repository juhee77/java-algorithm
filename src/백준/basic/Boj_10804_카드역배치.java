package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10804_카드역배치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] arr = new int[20];
        for (int i = 1; i <= 20; i++) {
            arr[i - 1] = i;
        }

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            for (int j = 0; j <= (b - a) / 2; j++) {
                int swap = arr[b - j];
                arr[b - j] = arr[a + j];
                arr[a + j] = swap;
            }
        }

        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
