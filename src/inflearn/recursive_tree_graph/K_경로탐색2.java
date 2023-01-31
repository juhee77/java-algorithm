package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K_경로탐색2 {
    private static boolean[][] edges;
    private static int v;
    private static boolean[] visited;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());
        edges = new boolean[v][v];
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            edges[a][b] = true;
        }

        visited = new boolean[v];
        visited[0] = true;
        dfs(0,"1");
        System.out.println(ans);
    }

    private static void dfs(int now, String x) {
        if (now == v-1) {
            System.out.println(x);
            ans ++;
        } else {
            for (int i = 0; i < v; i++) {
                if(edges[now][i]){
                    if (!visited[i]) {
                        visited[i] =true;
                        dfs(i, x + " " + (i + 1));
                        visited[i] = false;
                    }
                }
            }
        }
    }
}

//59 12 13 14 21 23 25 34 42 45