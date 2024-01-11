package 백준.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_23286_도비의영어공부 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            char first = st.nextToken().charAt(0);
            char second = Character.toUpperCase(first);
            int cnt = 0;

            if (first == '#') {
                break;
            } else {
                while (st.hasMoreElements()) {
                    for (char c : st.nextToken().toCharArray()) {
                        if (c == first || c == second) {
                            cnt++;
                        }
                    }
                }
                sb.append(first).append(" ").append(cnt).append("\n");

            }
        }
        System.out.println(sb);
    }
}
