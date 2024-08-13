package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11098_첼시를도와줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int max = 0;
            String maxName = null;
            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int money = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                if (max < money) {
                    max = money;
                    maxName = name;
                }
            }
            sb.append(maxName).append("\n");
        }
        System.out.println(sb);
    }
}
