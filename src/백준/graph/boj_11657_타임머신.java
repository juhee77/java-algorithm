package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11657_타임머신 {
    private static class root implements Comparable<root> {
        int end, cost;

        public root(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(root o) {
            return cost - o.cost;
        }

        @Override
        public String toString() {
            return "root{" +
                    "end=" + end +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<root>[] roots = new List[n];
        for (int i = 0; i < n; i++) {
            roots[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            roots[start].add(new root(end, cost));
        }


        int[] distance = new int[n];
        boolean[] visited = new boolean[n];
        int minusCnt = 0;

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        PriorityQueue<root> pq = new PriorityQueue<>();
        pq.add(new root(0, 0));
        while (!pq.isEmpty()) {
            root now = pq.poll();
            if (now.cost > distance[now.end]) continue;

            for (root nowRoot : roots[now.end]) {
                if (distance[nowRoot.end] > distance[now.end] + nowRoot.cost) {
                    distance[nowRoot.end] = distance[now.end] + nowRoot.cost;
                    pq.add(new root(nowRoot.end, distance[nowRoot.end]));
                }
                if (distance[now.end] < 0) {
                    visited[now.end] = true;
                    minusCnt++;
                }
            }
            if(minusCnt==n) break;
        }

        if (minusCnt == n) sb.append(-1);
        else {
            for (int i = 1; i < n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
