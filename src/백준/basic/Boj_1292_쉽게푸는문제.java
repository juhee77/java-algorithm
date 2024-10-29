package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1292_쉽게푸는문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int now = 0;
        int hold = 1;
        while (now + hold < a) {
            now += hold;
            hold++;
        }

        long ans = 0;
        int holdH = 0;
        for (int i = now; i <= b; i++) {
            if (a <= i)
                ans += hold;

            if (holdH == hold) {
                holdH = 0;
                hold++;
            }
            holdH++;
        }
        System.out.println(ans);
    }
}
