package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2660_회장뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], (int) 1e6);
            graph[i][i] = 1;
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (a == -2 && b == -2) break;
            graph[a][b] = graph[b][a] = 1;
        }

        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][p] + graph[p][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        List<Integer> humans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tempMax = 0;
            for (int j = 0; j < n; j++)
                tempMax = (graph[i][j] < (int) 1e6) ? Math.max(tempMax, graph[i][j]) : tempMax;

            if (tempMax < min) {
                min = tempMax;
                humans.clear();
                humans.add(i);
            } else if (tempMax == min) {
                humans.add(i);
            }
        }

        sb.append(min).append(" ").append(humans.size()).append("\n");
        for (Integer human : humans) sb.append(human + 1).append(" ");
        System.out.println(sb);
    }
}
