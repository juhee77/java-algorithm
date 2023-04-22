package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_100093_숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long num1 = Long.parseLong(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        long min = Math.min(num1, num2);
        long max = Math.max(num1, num2);
        StringBuilder sb = new StringBuilder();
        if (min == max) {
            sb.append(0);
        } else {
            sb.append(max - min - 1).append("\n");
            for (long i = min + 1; i < max; i++) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
