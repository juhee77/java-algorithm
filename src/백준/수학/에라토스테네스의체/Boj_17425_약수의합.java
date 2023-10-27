package 백준.수학.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17425_약수의합 {

    public static final int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] gx = new long[MAX];

        int tc = Integer.parseInt(br.readLine());
        gx[0] = 0;
        gx[1] = 1;
        for (int i = 2; i < MAX; i++) {
            gx[i] = gx[i - 1] + gx[i] + (i + 1);

            for (int j = i + i; j < MAX; j += i) {
                gx[j] += i;
            }
        }

        while (tc-- > 0) {
            int input = Integer.parseInt(br.readLine());
            sb.append(gx[input]).append("\n");
        }
        System.out.println(sb);
    }

}
