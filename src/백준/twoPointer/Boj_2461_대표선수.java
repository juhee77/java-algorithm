package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2461_대표선수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int classes = Integer.parseInt(st.nextToken());
        int students = Integer.parseInt(st.nextToken());

        int[][] all = new int[classes][students];
        for (int i = 0; i < classes; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < students; j++) {
                all[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(all[i]);
        }

        int[] indexes = new int[classes];
        int ans = Integer.MAX_VALUE;
        while (true) {
            int min = Integer.MAX_VALUE, max = 0;
            int minI = -1;

            for (int i = 0; i < classes; i++) {
                if (all[i][indexes[i]] < min) {
                    min = all[i][indexes[i]];
                    minI = i;
                }

                if (all[i][indexes[i]] > max) {
                    max = all[i][indexes[i]];
                }
            }

            ans = Math.min(ans, (max - min));
            if (++indexes[minI] >= students) break;
        }
        System.out.println(ans);
    }
}
