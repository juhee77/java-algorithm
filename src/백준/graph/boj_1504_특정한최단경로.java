package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class boj_1504_특정한최단경로 {
    static class Node implements Comparable<Node> {
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

    private static final int INF = 200_000*1000+1;
    //각 노드에 연결되어있는 노드의 정보를 담음
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    //edge수
    private static int edge;
    //최단거리 테이블
    private static int distanceStart[];
    private static int distancesA[];
    private static int distancesB[];


    private static void dijkstra(int start, int[] distance) {
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
        return ;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        edge = Integer.parseInt(st.nextToken());
        int bus = Integer.parseInt(st.nextToken());
        distanceStart = new int[edge];
        distancesA = new int[edge];
        distancesB = new int[edge];

        //그래프 초기화
        for (int i = 0; i < edge; i++)
            graph.add(new ArrayList<Node>());
        //최단거리 배열 초기화
        Arrays.fill(distanceStart, INF);
        Arrays.fill(distancesA, INF);
        Arrays.fill(distancesB, INF);

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            //무방향성 그래프!!!!
            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken())-1;
        int B = Integer.parseInt(st.nextToken())-1;

        dijkstra(0, distanceStart);
        dijkstra(A, distancesA);
        dijkstra(B, distancesB);


        //A->B
        int AB = distanceStart[A]+ distancesA[B]+ distancesB[edge-1];
        //B->A
        int BA = distanceStart[B]+ distancesB[A]+ distancesA[edge-1];

        int min = (Math.min(AB,BA)>=INF)? -1:Math.min(AB,BA);

        System.out.println(min);

    }
}
