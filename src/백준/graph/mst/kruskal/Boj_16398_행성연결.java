package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_16398_행성연결 {
    private static int[] parents;
    private static final PriorityQueue<Node> nodes = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == j) continue;
                nodes.add(new Node(i, j, num));
            }
            parents[i] = i;
        }


        long unionCost = 0;
        int unionCnt = 0;
        while (!nodes.isEmpty()) {
            Node poll = nodes.poll();
            int a = getParents(poll.n1);
            int b = getParents(poll.n2);
            if (a == b) continue;

            unionCost += poll.cost;
            union(a, b);
            if (unionCnt == n - 1) break;
        }

        System.out.println(unionCost);
    }

    private static void union(int a, int b) {
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static int getParents(int x) {
        if (parents[x] == x) return x;
        return parents[x] = getParents(parents[x]);
    }

    private static class Node implements Comparable<Node> {
        int n1;
        int n2;
        int cost;

        public Node(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
