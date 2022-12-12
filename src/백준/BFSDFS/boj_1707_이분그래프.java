package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1707_이분그래프 {
    private static final int RED = 1; //blue= -1
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v];
            for(int i=0;i<v;i++){
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                graph[start].add(end);
                graph[end].add(start);
            }

            int[] colored = new int[graph.length];
            boolean totalFlag = true;
            for (int i = 0; i < v && totalFlag; i++) {
                if (colored[i] == 0) {
                    totalFlag = bfs(i, colored);
                }
            }
            sb.append(totalFlag ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs(int start, int[] colored) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        if (colored[start] == 0) colored[start] = RED;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int e : graph[now]) {
                if (colored[e] == 0) {
                    colored[e] = -colored[now];
                    queue.add(e);
                } else {
                    if (colored[e] == colored[now]) return false;
                }
            }
        }
        return true;
    }
}
