package 백준.dynamicProgramming.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15681_트리와쿼리 {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        dp = new int[n];
        visited = new boolean[n];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited[r] = true;
        dfs(r);

        for (int i = 0; i < q; i++) {
            int query = Integer.parseInt(br.readLine()) - 1;
            sb.append(dp[query]).append("\n");
        }

        System.out.println(sb);
    }


    private static void dfs(int nowNode) {
        dp[nowNode] = 1;

        for (Integer child : graph.get(nowNode)) {
            if (visited[child]) continue;

            visited[nowNode] = true;
            dfs(child);
            dp[nowNode] += dp[child];
        }
    }
}
