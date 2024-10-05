package 백준.graph.mst.prim;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14621_나만안되는연애 {
    private static class Node implements Comparable<Node> {
        int next, distance;

        public Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    private static List<Node>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Character> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(i, st.nextToken().charAt(0));
        }

        graphs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<Node>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());

            if (map.get(a) != map.get(b)) {
                graphs[a].add(new Node(b, distance));
                graphs[b].add(new Node(a, distance));
            }
        }


        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        pq.add(new Node(0, 0));
        int ans = 0;
        int mstCnt = 0;
        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visited[now.next]) {
                visited[now.next] = true;
                mstCnt++;
                ans += now.distance;
                for (Node peer : graphs[now.next]) {
                    if (!visited[peer.next]) {
                        pq.add(new Node(peer.next, peer.distance));
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(visited));
        System.out.println(mstCnt == n ? ans : -1);
    }
}
