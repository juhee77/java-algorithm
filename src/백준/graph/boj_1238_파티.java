package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1238_파티 {
    static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            } else return 1;
        }
    }

    private static final int INF = (int) 1e9;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int distance[];
    private static int savedis[];
    private static int city;
    private static int point;
    private static int max = 0;

    private static void dijkstra(int start, boolean flag) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.index;
            int dist = node.distance;
            //현재 노드가 이미 방문한 노드라면 지나가기
            if (distance[now] < dist) continue;

            //현재노드와 인접 노드 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).distance;
                //현재 노드 방문후 다른노드 방문하는게 짧은경우
                if (cost < distance[graph.get(now).get(i).index]) {
                    distance[graph.get(now).get(i).index] = cost;
                    queue.offer((new Node(graph.get(now).get(i).index, cost)));
                }
            }
            if (now == point && flag) //파티 방문장소의 최소값
            {
                savedis[start] = distance[point];
                //System.out.println("Arrays.toString(savedis) = " + Arrays.toString(savedis));
                return;
            }
        }

        if (!flag) { //point인 경우
            //System.out.println("Arrays.toString(distance) = " + Arrays.toString(distance));
            for (int i = 0; i < city; i++) {
                max = Math.max(savedis[i] + distance[i], max);
            }
        }

        return;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        city = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        point = Integer.parseInt(st.nextToken()) - 1;

        //각 노드 리스트 초기화
        for (int i = 0; i < city; i++) graph.add(new ArrayList<Node>());
        distance = new int[city];
        savedis = new int[city];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, d));
        }


        for (int i = 0; i < city; i++) {
            if (i == point) continue;
            Arrays.fill(distance, INF);
            dijkstra(i, true);
        }
        Arrays.fill(distance, INF);
        dijkstra(point, false);

        System.out.println(max);
    }
}
