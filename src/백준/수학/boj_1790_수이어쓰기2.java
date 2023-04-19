package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1790_수이어쓰기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long now = 1;
        long pow = 1;
        long num;//지금 숫자
        while (true) {
            if (m <= 9 * pow * now) {
                num = pow + (m / now) - 1;
                break;
            } else {
                m -= 9 * pow * now;
                m++;
                pow *= 10;
                now++;
            }
        }

        if (num > n) System.out.println(-1);
        else {
            long l = m % now;
            String string = Long.toString(num);
            System.out.println(string.charAt((int) l));
        }
    }
}
