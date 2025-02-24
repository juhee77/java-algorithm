package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_24479_알고리즘수업dfs1 {
    private static ArrayList<Integer>[] graph;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());


        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int e1 = Integer.parseInt(st.nextToken()) - 1;
            int e2 = Integer.parseInt(st.nextToken()) - 1;

            graph[e1].add(e2);
            graph[e2].add(e1);
        }

        arr = new int[n];
        visited = new boolean[n];
        int depth = 1;
        arr[r - 1] = depth++;
        visited[r - 1] = true;
        dfs(r - 1, depth);

        for (int i : arr) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int now, int depth) {
        Collections.sort(graph[now]);
        for (Integer next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                arr[next] = depth;
                depth = dfs(next, depth + 1);
            }
        }
        return depth;
    }
}
