package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1267_핸드폰뱅크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int cs = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int y = 0;
        int m = 0;
        while (cs-- > 0) {
            int i = Integer.parseInt(st.nextToken());
            y += ((i / 30) + 1) * 10;
            m += ((i / 60) + 1) * 15;
        }

        if (y == m) {
            sb.append("Y M ");
            sb.append(y);
        } else if (y > m) {
            sb.append("M ");
            sb.append(m);
        } else {
            sb.append("Y ");
            sb.append(y);
        }

        System.out.println(sb);

    }
}
