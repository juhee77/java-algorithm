package 백준.backTracking.bitmaking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1961_도영이가만든음식 {
    private static long[][] flavor;
    private static long min = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = Integer.parseInt(br.readLine());
        flavor = new long[cnt][2];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            flavor[i][0] = Long.parseLong(st.nextToken());
            flavor[i][1] = Long.parseLong(st.nextToken());
        }

        findMin(0, 0, cnt);
        System.out.println(min);
    }

    private static void findMin(int arr, int nowD, int n) {
        if (nowD == n) {
            if (arr == 0) return;
            char[] chars = Integer.toBinaryString(arr).toCharArray();

            long sour = 1;
            long bitter = 0;
            int startPoint = n - chars.length;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    sour *= flavor[i + startPoint][0];
                    bitter += flavor[i + startPoint][1];
                }
            }
            min = Math.min(min, Math.abs(sour - bitter));
        } else {
            findMin((arr | 1 << (nowD)), nowD + 1, n);
            findMin(arr, nowD + 1, n);
        }
    }
}
