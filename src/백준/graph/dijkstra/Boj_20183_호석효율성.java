package 백준.graph.dijkstra;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20183_호석효율성 {

    static class Node implements Comparable<Node> {
        private final int index;
        private final long distance;

        public Node(int index, long distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public long getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node other) {
            if (this.distance < other.distance) {
                return -1;
            } else return 1;
        }
    }

    private static int n, m, a, b;
    private static long c;
    private static final long INF = (long) 1e14 + 1; //범위가 너무 중요하다. 가지고 있는 돈이 더 많을 수 있따..
    //각 노드에 연결되어있는 노드의 정보를 담음
    private static final ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    //최단거리 테이블
    private static long[] distance;

    private static boolean able(int mid) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(a, 0));
        distance = new long[n];
        Arrays.fill(distance, INF);
        distance[a] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now = node.getIndex();
            long dist = node.getDistance();
            //현재 노드가 이미 방문한 노드라면 지나가기
            if (distance[now] < dist) continue;

            //현재노드와 인접 노드 확인
            for (int i = 0; i < graph.get(now).size(); i++) {
                if (graph.get(now).get(i).getDistance() > mid) { //지나가지 못하게 한다.
                    continue;
                }
                long cost = distance[now] + graph.get(now).get(i).getDistance();
                //현재 노드 방문후 다른노드 방문하는게 짧은경우
                if (cost < distance[graph.get(now).get(i).getIndex()]) {
                    distance[graph.get(now).get(i).getIndex()] = cost;
                    queue.offer((new Node(graph.get(now).get(i).getIndex(), cost)));
                }
            }
        }

        if (distance[b] == INF) {
            return false;//다다를수 없다.
        }
        return distance[b] <= c;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken()) - 1;
        b = Integer.parseInt(st.nextToken()) - 1;
        c = Long.parseLong(st.nextToken());


        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Node>());
        }

        HashSet<Integer> allMoneys = new HashSet<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int money = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, money)); //도착, 가격
            graph.get(end).add(new Node(start, money));
            allMoneys.add(money);
        }

        List<Integer> allMoney = new ArrayList<>(allMoneys);
        Collections.sort(allMoney);
        int start = 0;
        int end = allMoney.size() - 1;
        long max = INF;

        while (start <= end) {
            int mid = (start + end) / 2;
            Integer topShame = allMoney.get(mid);
            if (able(topShame)) {
                end = mid - 1;
                max = topShame;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(max == INF ? -1 : max);

    }
}
