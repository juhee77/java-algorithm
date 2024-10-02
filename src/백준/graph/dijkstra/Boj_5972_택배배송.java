package 백준.graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_5972_택배배송 {
    private static class Node implements Comparable<Node> {
        public int next;
        public int distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    private static final List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        for (int i = 0; i < a; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, distance));
            graph.get(end).add(new Node(start, distance));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] distances = new int[a];
        queue.offer(new Node(0, 0));
        Arrays.fill(distances, (int) 1e9);
        distances[0] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.next;
            int dist = node.distance;
            //현재 노드가 이미 방문한 노드라면 지나가기
            if (distances[now] < dist) continue;

            for (Node next : graph.get(now)) {
                int cost = distances[now] + next.distance;
                //현재 노드 방문후 다른노드 방문하는게 짧은경우
                if (cost < distances[next.next]) {
                    distances[next.next] = cost;
                    queue.offer((new Node(next.next, cost)));
                }
            }
        }

//        System.out.println(Arrays.toString(distances));
        System.out.println(distances[a - 1]);

    }
}
