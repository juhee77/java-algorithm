package 백준.dynamicProgramming.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] up = new int[h + 1];
        int[] down = new int[h + 1];

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                down[now]++;
            } else {
                up[h - now + 1]++;
            }
        }

        for (int i = h - 1; 0 <= i; i--) {
            down[i] += down[i + 1];
        }

        for (int i = 1; i <= h; i++) {
            up[i] += up[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int now = up[i] + down[i];
            if (now < min) {
                min = now;
                cnt = 1;
            } else if (now == min) {
                cnt++;
            }
        }
        System.out.println(min + " " + cnt);
    }
}
