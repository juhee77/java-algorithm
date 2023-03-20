package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11657_타임머신_벨만 {

    public static final long MAX_VALUE = Long.MAX_VALUE;

    private static class Edge {
        int start, end;
        long cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, cost));
        }


        long[] distance = new long[n];
        Arrays.fill(distance, MAX_VALUE);
        distance[0] = 0;

        //도시 개수 만큼 반복(최단 거리는 모든 도시를 방문한 경우 내에서 반드시 존재해야한다.)
        for (int i = 0; i < n; i++) {
            //모든 간선에 대해서
            for (Edge now : edges) {
                if (distance[now.start] == MAX_VALUE) continue; //방문한 적 없으면 넘어간다

                if (distance[now.end] > distance[now.start] + now.cost) { //오버 플로우 일어난다.
                    distance[now.end] = distance[now.start] + now.cost;
                }
            }
        }


        boolean miCycle = false; //음수 사이클
        for (Edge edge : edges) {
            if (distance[edge.start] == MAX_VALUE) continue;  //방문한 적 없으면 넘어간다

            if (distance[edge.end] > distance[edge.start] + edge.cost) {
                miCycle = true;
                break;
            }
        }

        if (miCycle) sb.append("-1").append("\n");
        else {
            for (int i = 1; i < n; i++) {
                if (distance[i] == MAX_VALUE) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(distance[i]).append("\n");
                }
            }
        }
        System.out.print(sb);
    }
}
