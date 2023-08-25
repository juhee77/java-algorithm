package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15591_MoonTube {
    private static int n;
    private static int q;
    private static List<List<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int score = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, score});
            graph.get(b).add(new int[]{a, score});
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int minScore = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken()) - 1;
            sb.append(getCnt(minScore, start)).append("\n");
        }
        System.out.println(sb);

    }

    private static int getCnt(int minScore, int start) {
        boolean[] visited = new boolean[n];
        visited[start] = true;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(start);
        int point = -1;

        while (!queue.isEmpty()) {
            point++;
            Integer poll = queue.poll();

            for (int[] child : graph.get(poll)) {
                int next = child[0];
                int score = child[1];

                if (!visited[next] && score >= minScore) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return point;
    }


}
