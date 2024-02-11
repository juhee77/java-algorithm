package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5063_TGN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tcCnt = Integer.parseInt(br.readLine());
        while (tcCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int add = b - c;
            if (a < add) {
                sb.append("advertise");
            } else if (a == add) {
                sb.append("does not matter");
            } else {
                sb.append("do not advertise");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
