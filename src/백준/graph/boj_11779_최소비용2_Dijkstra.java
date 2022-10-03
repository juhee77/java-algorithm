package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_11779_최소비용2_Dijkstra {

    public static class Node implements Comparable<Node> {
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            } else return 1;
        }
    }

    private static final int INF = (int) 1e9;
    //각 노드에 연결되어있는 노드의 정보를 담음
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    private static ArrayList<ArrayList<Integer>> save = new ArrayList<>();
    //edge수
    private static int city;
    //최단거리 테이블
    private static int distance[];
    private static StringBuilder sb = new StringBuilder();
    private static int cnt = 0;

    private static void dijkstra(int start, int end) {
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
                    save.get(graph.get(now).get(i).getIndex()).clear();
                    save.get(graph.get(now).get(i).getIndex()).addAll(save.get(now));
                    save.get(graph.get(now).get(i).getIndex()).add(now + 1);
                    queue.offer((new Node(graph.get(now).get(i).getIndex(), cost)));
                }
            }
        }
        return;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        distance = new int[city];

        //그래프 초기화
        for (int i = 0; i < city; i++) {
            graph.add(new ArrayList<Node>());
            save.add(new ArrayList<Integer>());
        }
        //최단거리 배열 초기화
        Arrays.fill(distance, INF);

        for (int i = 0; i < bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start - 1, end - 1);
        System.out.println(distance[end - 1]);
        System.out.println(save.get(end - 1).size() + 1);
        for (int e : save.get(end - 1)) sb.append(e + " ");
        System.out.println(sb + String.valueOf(end));

    }
}
/*
5
5
3 4 1
3 5 1
5 4 1
4 1 1
3 1 5
3 1

5
5
3 4 9
3 5 1
5 4 1
4 1 1
3 1 5
3 1
 */