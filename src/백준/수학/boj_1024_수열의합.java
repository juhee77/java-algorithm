package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1024_수열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());


        // 수열은 x, x+1, x+2, ... x+l-1까지가 최소이므로 x*l + (l)*(l-1)/2 이다.
        // n = x*l +(l)*(l-1)/2
        int x = -1;
        for (; l <= 100; l++) {
            int temp = (l) * (l - 1) / 2;
            if (n < temp) {
                break;
            } else if (((double) n - temp) % l == 0) {
                x = (n - temp) / l; // 시작점
                break;
            }
        }

        if (x == -1) {
            sb.append(-1);
        } else {
            for (int i = 0; i < l; i++) {
                sb.append(x + i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
