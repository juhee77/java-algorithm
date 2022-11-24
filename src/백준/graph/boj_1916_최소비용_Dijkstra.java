package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    private final int index;
    private final int distance;

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

public class boj_1916_최소비용_Dijkstra {
    private static final int INF = (int) 1e9;
    //각 노드에 연결되어있는 노드의 정보를 담음
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단거리 테이블
    private static int[] distance;

    private static int dijkstra(int start, int end) {
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
        return distance[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //edge수
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        distance = new int[city];

        //그래프 초기화
        for (int i = 0; i < city; i++)
            graph.add(new ArrayList<>());
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
        System.out.println(dijkstra(start - 1, end - 1));

        /*플로이드 워셜*/
//        for(int p = 0;p<city;p++){
//            for(int i=0;i<city;i++){
//                for(int j=0;j<city;j++){
//                    arr[i][j] = Math.min(arr[i][p]+arr[p][j],arr[i][j]);
//                }
//
//            }
//        }
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int start = Integer.parseInt(st.nextToken());
//        int end = Integer.parseInt(st.nextToken());
//        System.out.println(arr[start - 1][end - 1]);

    }
}
