package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5635_생일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = 0;

        String minName = null, maxName = null;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String tempName = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int temp = day + month * 12 + (year - 1990) * 365;
            if (temp < min) {
                min = temp;
                minName = tempName;
            }

            if (max < temp) {
                max = temp;
                maxName = tempName;
            }
        }
        sb.append(maxName).append("\n").append(minName);
        System.out.println(sb);
    }
}
