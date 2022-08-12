package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_10250_ACM호텔 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            String NH, NW;
            if (N % H == 0) {
                NH = String.valueOf(H);
                NW = (N / H < 10) ? "0" + (N / H) : String.valueOf((N / H));
            } else {
                NH = String.valueOf(N % H);
                NW = (N / H + 1 < 10) ? "0" + (N / H + 1) : String.valueOf((N / H + 1));
            }

            sb.append(NH + NW).append('\n');
        }
        System.out.println(sb);
    }
}
