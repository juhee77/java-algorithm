package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1022_소용돌이 {
    private static final int HOLD = 5000;
    private static int max = 0;
    private static int sR, sC, eR, eC;
    private static int[][] ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        sR = Integer.parseInt(st.nextToken());
        sC = Integer.parseInt(st.nextToken());
        eR = Integer.parseInt(st.nextToken());
        eC = Integer.parseInt(st.nextToken());

        int maxR = Math.max(Math.abs(sR), Math.abs(eR));
        int maxC = Math.max(Math.abs(sC), Math.abs(eC));

        ans = new int[eR - sR + 1][eC - sC + 1];
        int now = 1;
        int r = HOLD, c = HOLD;
        int sz = 0;
        set( now++, r, c);
        while (maxR >= Math.abs(r - HOLD )|| maxC >= Math.abs(HOLD - c)) {
            sz++;
            for (int i = 0; i < sz; i++) set(now++, r, ++c);
            for (int i = 0; i < sz; i++) set(now++, --r, c);
            sz++;
            for (int i = 0; i < sz; i++) set(now++, r, --c);
            for (int i = 0; i < sz; i++) set(now++, ++r, c);

        }

        int numSize = max >= 10 ? (int) Math.log10(max) : 0;
        for (int[] temp : ans) {
            for (int num : temp) {
                int tempNumSize = num >= 10 ? (int) Math.log10(num) : 0;
                sb.append(" ".repeat(numSize - tempNumSize)).append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void set(int now, int r, int c) {
        if (HOLD + sR <= r && r <= HOLD + eR && HOLD + sC <= c && c <= HOLD + eC) {
            ans[r - HOLD - sR][c - HOLD - sC] = now;
            max = Math.max(max, now);
        }
    }
}
