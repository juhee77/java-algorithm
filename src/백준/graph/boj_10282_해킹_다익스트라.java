package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_10282_해킹_다익스트라 {
    private static final int INF = 1_000_000_000;
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] hackedTime;

    private static class Node implements Comparable<Node> {
        int index, time;

        public Node(int index, int distance) {
            this.index = index;
            this.time = distance;
        }
        @Override
        public int compareTo(Node other) {
            if (this.time < other.time) return -1; //오름차순 정렬
            return 1;
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        hackedTime[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.index;
            int time = now.time;
            if (hackedTime[index] < time) continue;

            for (int i = 0; i < graph.get(index).size(); i++) {
                int tempTime = hackedTime[index] + graph.get(index).get(i).time;
                if (tempTime < hackedTime[graph.get(index).get(i).index]) {
                    hackedTime[graph.get(index).get(i).index] = tempTime;
                    pq.add(new Node(graph.get(index).get(i).index, tempTime));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()) - 1;

            hackedTime = new int[n];
            Arrays.fill(hackedTime, INF);
            graph.clear();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            while (d-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int time = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Node(a, time));
            }

            dijkstra(c);

            int hackedTimeMin = 0;
            int hackedCnt = 0;
            for (int e : hackedTime) {
                if(e==INF) continue;
                hackedCnt++;
                hackedTimeMin = Math.max(hackedTimeMin,e);
            }
            sb.append(hackedCnt).append(" ").append(hackedTimeMin).append("\n");
        }
        System.out.println(sb);
    }
}
/*
5 5 1
        3 4 1
        3 5 1
        5 4 1
        4 1 1
        3 1 5
 */
