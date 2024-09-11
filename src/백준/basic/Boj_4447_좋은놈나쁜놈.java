package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4447_좋은놈나쁜놈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int g = 0, b = 0;
            String name = br.readLine();
            for (char c : name.toCharArray()) {
                if (c == 'g' || c == 'G') {
                    g++;
                } else if (c == 'B' || c == 'b') {
                    b++;
                }
            }

            sb.append(name+" "+"is");
            if (g > b) {
                sb.append(" GOOD\n");
            } else if (g == b) {
                sb.append(" NEUTRAL\n");
            } else {
                sb.append(" A BADDY\n");
            }
        }
        System.out.println(sb);
    }
}
