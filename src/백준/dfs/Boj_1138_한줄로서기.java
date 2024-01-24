package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1138_한줄로서기 {
    private static int[] ans;
    private static boolean[] vistied;
    private static int[] now;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = new int[n];
        now = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        vistied = new boolean[n];
        if (dfs(0)) {
            for (int i : now) {
                sb.append((i + 1)).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static boolean dfs(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = 0; j < i; j++) {
                    if (now[j] > now[i]) {
                        cnt++;
                    }
                }

                if (ans[now[i]] != cnt) {
                    return false;
                }
            }

            return true;
        }

        for (int i = 0; i < n; i++) {
            if (!vistied[i]) {
                now[depth] = i;
                vistied[i] = true;
                if (dfs(depth + 1)) {
                    return true;
                }
                vistied[i] = false;
            }
        }
        return false;
    }
}
