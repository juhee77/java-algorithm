package 백준.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_18352_특정거리의도시찾기_DFS {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder("-1");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }

        //bfs
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(x);
        boolean[] dist = new boolean[n + 1];
        dist[x] = true;
        for (int nowDepth = 0; nowDepth <= k  && !q.isEmpty(); nowDepth++) {
            if (nowDepth == k ) {
                sb = new StringBuilder();
                for (Integer now : q) {
                    sb.append(now).append("\n");
                }
                break;
            }

            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                int now = q.poll();
                for (Integer child : graph.get(now)) {
                    if (dist[child]) continue;
                    q.add(child);
                    dist[child] = true;
                }
            }
        }


        System.out.println(sb);
    }
}
