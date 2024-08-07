package 백준.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_숫자놀이_2777 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            //2,3,5,7로 안 나눠지면 끝임
            int cnt = (n == 1) ? 1 : 0;
            while (1 < n) {
                boolean flag = true;
                cnt++;
                for (int i = Math.min(9, n); 2 <= i; i--) {
                    if (n % i == 0) {
                        n /= i;
                        flag = false;
                        break;
                    }
                }
                if (flag) break;
            }
            sb.append(n == 1 ? cnt : -1).append("\n");
        }
        System.out.println(sb);
    }
}
