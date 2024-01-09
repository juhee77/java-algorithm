package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_6497_전력난 {
    private static int[] parents;

    private static class Node implements Comparable<Node> {
        int n1, n2;
        int cost;

        public Node(int n1, int n2, int cost) {
            this.n1 = n1;
            this.n2 = n2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//house
            int m = Integer.parseInt(st.nextToken()); //roads

            if (n == 0 && m == 0) {
                break;
            }

            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

            PriorityQueue<Node> allRoads = new PriorityQueue<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                allRoads.add(new Node(x, y, z));
            }

            int cost = 0;
            while (!allRoads.isEmpty()) {
                Node poll = allRoads.poll();
                if (findParents(poll.n1) != findParents(poll.n2)) {
                    union(poll.n1, poll.n2);
                } else {
                    cost += poll.cost;

                }
            }
            sb.append(cost).append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static int findParents(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = findParents(parents[x]);
    }
}
