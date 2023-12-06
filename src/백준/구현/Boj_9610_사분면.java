package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9610_사분면 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] ans = new int[5];
        String[] ansStr = new String[]{"Q1", "Q2", "Q3", "Q4", "AXIS"};

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) {
                ans[4]++;
            } else if (x < 0 && y < 0) {
                ans[2]++;
            } else if (0 < x && y < 0) {
                ans[3]++;
            } else if (0 < x) {
                ans[0]++;
            } else {
                ans[1]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            sb.append(ansStr[i]).append(": ").append(ans[i]).append("\n");
        }

        System.out.println(sb);


    }
}
