package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5355_화성수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            double ans = Double.parseDouble(st.nextToken());

            while (st.hasMoreElements()) {
                char c = st.nextToken().charAt(0);
                if (c == '@') {
                    ans *= 3;
                } else if (c == '%') {
                    ans += 5;
                } else if (c == '#') {
                    ans -= 7;
                } else {
                    throw new IllegalArgumentException("잘못된 기호");
                }
            }

            sb.append(String.format("%.2f", ans)).append("\n");
        }

        System.out.println(sb);
    }
}
