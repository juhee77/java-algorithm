package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1244_스위치켜고끄기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean[] switches = new boolean[n];
        for (int i = 0; i < n; i++) {
            switches[i] = Integer.parseInt(st.nextToken()) != 0;
        }

        int r = Integer.parseInt(br.readLine());
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (sex == 1) {
                for (int j = index; j <= n; j += index) {
                    switches[j - 1] = !switches[j - 1];
                }
            } else {
                int hold = 1;
                int rIndex = index - 1;
                for (; hold < n; hold++) {
                    if (rIndex - hold < 0 || n <= rIndex + hold) break;
                    if (switches[rIndex - hold] != switches[rIndex + hold]) break;
                }
                for (int j = 0; j < hold; j++) {
                    switches[rIndex - j] = switches[rIndex + j] = !switches[rIndex + j];
                }
            }
        }
        for (int j = 1; j <= n; j++) {
            sb.append(switches[j - 1] ? "1 " : "0 ");
            if (j % 20 == 0) sb.append("\n");
        }
        System.out.println(sb);
    }
}
