package 백준.backTracking.nm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651_NM3 {
    private static int n = 0;
    private static int m = 0;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr=new int[m];

        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int d) {
        if (d == m) {
            for (int e : arr) sb.append(e).append(" ");
            sb.append("\n");

        } else {
            for (int i = 1; i <= n; i++) {
                arr[d] = i;
                dfs(d + 1);
            }
        }
    }
}




