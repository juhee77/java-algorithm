package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_22966_가장쉬운문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int lowLevel = Integer.MAX_VALUE;
        String ans = "";
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int level = Integer.parseInt(st.nextToken());
            if (lowLevel > level) {
                ans = s;
                lowLevel = level;
            }
        }
        System.out.println(ans);
    }
}
