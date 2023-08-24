package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1240_노드사이의거리 {
    private static List<List<int[]>> tree;
    private static boolean[] visited;
    private static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            tree.get(a).add(new int[]{b, cost});
            tree.get(b).add(new int[]{a, cost});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int target = Integer.parseInt(st.nextToken()) - 1;
            visited = new boolean[N];
            visited[start] = true;
            dfs(start, target, 0);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int before, int target, int sum) {
        if (before == target) {
            ans = sum;
        } else {
            for (int[] child : tree.get(before)) {
                if (!visited[child[0]]) {
                    visited[child[0]] = true;
                    dfs(child[0], target, sum + child[1]);
                }
            }
        }
    }
}
