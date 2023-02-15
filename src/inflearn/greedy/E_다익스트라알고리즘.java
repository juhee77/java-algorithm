package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E_다익스트라알고리즘 {
    private static List<List<Node>> graph = new ArrayList<>();
    private static int n;
    private static int[] dist;
    private static final int INF = (int) 1e6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, cost));
        }
        dist = new int[n];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        pQueue.add(new Node(0, 0));
        dist[0] = 0;

        while (!pQueue.isEmpty()) {
            Node nowNode = pQueue.poll();

            if(dist[nowNode.idx]< nowNode.cost) continue;

            for (Node next : graph.get(nowNode.idx)) {
                if (dist[next.idx] > nowNode.cost + next.cost) {
                    dist[next.idx] = nowNode.cost + next.cost;
                    pQueue.offer(new Node(next.idx, nowNode.cost+next.cost));
                }
            }
        }

        /*my*/
//        while (!pQueue.isEmpty()) {
//            Node nowNode = pQueue.poll();
//
//            for (Node next : graph.get(nowNode.idx)) {
//                if (dist[next.idx] > dist[nowNode.idx] + next.cost) {
//                    dist[next.idx] = dist[nowNode.idx] + next.cost;
//                    pQueue.offer(new Node(next.idx, dist[next.idx]));
//                }
//            }
//        }


        for (int i = 1; i < n; i++) {
            String ans = (dist[i] == INF) ? "impossible" : String.valueOf(dist[i]);
            System.out.println((i + 1) + " " + ans);
        }
//        System.out.println(Arrays.toString(dist));


    }

    private static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }
}

/*
6 9
1 2 12
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
 */
