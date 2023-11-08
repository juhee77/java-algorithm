package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_9506_약수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            int cnt = 0;
            StringBuilder temp = new StringBuilder(n + " = ");
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    cnt += i;
                    temp.append(i).append(" + ");
                }
            }

            if (cnt == n) {
                sb.append(temp.substring(0, temp.length() - 3));
            } else {
                sb.append(n).append(" is NOT perfect.");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}
