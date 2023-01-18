package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_부분집합구하기_DFS {
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        solution(n);
    }

    private static void solution(int n) {
        visited = new boolean[n];
        dfs(0, n);
    }

    private static void dfs(int nowDepth, int n) {
        if (nowDepth == n) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) System.out.print((i + 1) + " ");
            }
            System.out.println();
        } else {
            visited[nowDepth] = true;
            dfs(nowDepth + 1, n);
            visited[nowDepth] = false;
            dfs(nowDepth + 1, n);
        }
    }
}
