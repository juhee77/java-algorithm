package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_10282_해킹_다익스트라ver2 {
    private static final StringBuilder sb = new StringBuilder();
    private static final int INF = 1_000_000_000;

    //현재 노드가 어떤 다른 노드에 영향을 미치는가
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단거리 보관
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
        //최단 시간 순으로 정렬되어 있다.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        hackedTime[start] = 0;
        int hackedTimeMin = 0;
        int hackedCnt = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int index = now.index;
            int time = now.time;
            //이전에 방문된 노드라면 넘어간다.
            if (hackedTime[index] < time) continue;
            hackedCnt++; // 감염된 노드
            hackedTimeMin = time; // 마지막 감염 값

            for (int i = 0; i < graph.get(index).size(); i++) {
                // 현재 노드를 거처서 i로 가는 경우 최단경로
                int tempTime = hackedTime[index] + graph.get(index).get(i).time;
                if (tempTime < hackedTime[graph.get(index).get(i).index]) {
                    //만약 최단시간이 갱신된다면 이 노드를 거쳐가는 방법을 다시 갱신
                    hackedTime[graph.get(index).get(i).index] = tempTime;
                    pq.add(new Node(graph.get(index).get(i).index, tempTime));
                }
            }
        }

        sb.append(hackedCnt).append(" ").append(hackedTimeMin).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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
        }
        System.out.println(sb);
    }
}