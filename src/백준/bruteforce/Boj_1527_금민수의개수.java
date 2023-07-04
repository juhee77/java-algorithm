package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1527_금민수의개수 {
    public static int max, small=Integer.MAX_VALUE;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        small = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());
        dfs("");
        System.out.println(cnt);
    }

    public static void dfs(String now) {
        if (10 <= now.length()) return;
        if (!now.equals("")) {
            int i = Integer.parseInt(now);
            if (small <= i && i <= max) {
//                System.out.println(i);
                cnt++;
            }
            if (max < i) return;
        }

        dfs(now + "4");
        dfs(now + "7");
    }
}
