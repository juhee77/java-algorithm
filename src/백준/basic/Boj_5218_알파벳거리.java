package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5218_알파벳거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            char[] chars1 = st.nextToken().toCharArray();
            char[] chars2 = st.nextToken().toCharArray();
            sb.append("Distances:");
            for (int i = 0; i < chars1.length; i++) {
                sb.append(" " + (chars2[i] - chars1[i]+26)%26);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
