package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_역사_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int history = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];

        while (history-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a][b] = -1;
            graph[b][a] = 1;
        }


        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 0) {
                        if (graph[i][k] == 1 && graph[k][j] == 1) graph[i][j] = 1;
                        else if (graph[i][k] == -1 && graph[k][j] == -1) graph[i][j] = -1;
                    }
                }
            }
        }

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            sb.append(graph[s][e]).append("\n");
        }
        System.out.println(sb);
    }
}
