package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2490_윷놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0)
                    cnt++;
            }

            switch (cnt) {
                case 1:
                    sb.append("A");
                    break;
                case 2:
                    sb.append("B");
                    break;
                case 3:
                    sb.append("C");
                    break;
                case 4:
                    sb.append("D");
                    break;
                case 0:
                    sb.append("E");
                    break;
                default:
                    break;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
