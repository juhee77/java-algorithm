package 백준.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2211_네트워크복구 {

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    static int N; 
    static ArrayList<ArrayList<Node>> graph; 
    static int[] distances; 
    static int[] prevNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        distances = new int[N + 1];
        prevNode = new int[N + 1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        sb.append(N - 1).append("\n");
        for (int i = 2; i <= N; i++) {
            sb.append(i).append(" ").append(prevNode[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distances[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int now = currentNode.index;
            int cost = currentNode.cost;

            if (distances[now] < cost) {
                continue;
            }

            for (Node nextNode : graph.get(now)) {
                int newCost = distances[now] + nextNode.cost;
                if (newCost < distances[nextNode.index]) {
                    distances[nextNode.index] = newCost;
                    //  최단 경로가 갱신되었으므로, nextNode로 가는 직전 경로는 now임을 기록
                    prevNode[nextNode.index] = now;
                    pq.offer(new Node(nextNode.index, newCost));
                }
            }
        }
    }
}