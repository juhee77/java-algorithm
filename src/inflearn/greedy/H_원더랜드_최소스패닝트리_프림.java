package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//크루스칼 -> union find
//프림 -> PriorityQueue 사용

public class H_원더랜드_최소스패닝트리_프림 {
    private static class Node implements Comparable<Node> {
        int idx, cost;

        public Node(int end, int cost) {
            this.idx = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static List<List<Node>> graph = new ArrayList<>();
    public static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        int ans = 0;
        ch = new boolean[v];

        while (!pq.isEmpty()) { //갈 수 있는 정점중 최단 값을 선택해 나가면서 확장한다.
            Node poll = pq.poll();

            if (!ch[poll.idx]) { //만약 해당 정점에서 나가는것중 체크 하지 않은 경우
                ch[poll.idx] = true; //해당 정점에서 나가는것 체크
                ans += poll.cost;
                for (Node node : graph.get(poll.idx)) {
                    if (!ch[poll.idx]) { // 방문이 되지 않은 노드만
                        pq.add(new Node(node.idx, node.cost));//연결된 간선 정보를 넣어준다.
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
