package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class boj_1753_최단경로_다익스트라 {
    private static final int INF = (int) 1e9;
    //각 노드에 연결되어있는 노드의 정보를 담음
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단거리 테이블
    private static int[] distance;

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.getIndex();
            int dist = node.getDistance();
            //현재 노드가 이미 방문한 노드라면 지나가기
            if (distance[now] < dist) continue;

            //현재노드와 인접 노드 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = distance[now] + graph.get(now).get(i).getDistance();
                //현재 노드 방문후 다른노드 방문하는게 짧은경우
                if (cost < distance[graph.get(now).get(i).getIndex()]) {
                    distance[graph.get(now).get(i).getIndex()] = cost;
                    queue.offer((new Node(graph.get(now).get(i).getIndex(), cost)));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //edge수
        int edge = Integer.parseInt(st.nextToken());
        int bus = Integer.parseInt(st.nextToken());
        distance = new int[edge];

        //그래프 초기화
        for (int i = 0; i < edge; i++)
            graph.add(new ArrayList<>());
        //최단거리 배열 초기화
        Arrays.fill(distance, INF);

        int goal = Integer.parseInt(br.readLine()) - 1;

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(goal);
        for (int j : distance)
            if (j == INF) sb.append("INF" + "\n");
            else sb.append(j).append("\n");

        System.out.println(sb);

    }
}
