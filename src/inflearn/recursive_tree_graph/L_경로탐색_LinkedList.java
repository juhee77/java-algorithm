package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class L_경로탐색_LinkedList {
    static int vertex, answer = 0;
    static boolean[] visited;
    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
        }

        visited = new boolean[vertex];
        visited[0] = true;
        dfs(0, "1");

    }

    private static void dfs(int now, String x) {
        if (now == vertex) {
            answer++;
            System.out.println(x);
        } else {
            for (Integer next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dfs(next, x + " " + next);
                    visited[next] = false;
                }
            }
        }
    }
}
