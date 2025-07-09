package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2444_알고리즘수업BFS1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < n; i++) {
            Collections.sort(graph.get(i)); // 인접 리스트 오름차순 정렬
        }

        int[] visited = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        int order = 1;
        q.add(s - 1);
        visited[s - 1] = order++;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (visited[next] == 0) {
                    visited[next] = order++;
                    q.add(next);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }
}
