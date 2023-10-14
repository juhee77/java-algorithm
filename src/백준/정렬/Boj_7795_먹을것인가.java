package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7795_먹을것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int aCnt = Integer.parseInt(st.nextToken());
            int bCnt = Integer.parseInt(st.nextToken());

            int[] aArr = new int[aCnt];
            int[] bArr = new int[bCnt];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < aCnt; i++) {
                aArr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bCnt; i++) {
                bArr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(aArr);
            Arrays.sort(bArr);

            int aIdx = aCnt-1;
            int bIdx = bCnt-1;

            long ans = 0;
            while (0 <= aIdx && 0 <= bIdx) {

                if (bArr[bIdx] < aArr[aIdx]) {
                    ans += (bIdx+1);
                    aIdx--;
                }else {
                    bIdx--;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
