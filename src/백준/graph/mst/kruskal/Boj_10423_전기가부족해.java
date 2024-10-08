package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10423_전기가부족해 {
    private static int[] parents;
    private static HashSet<Integer> elec = new HashSet<>();


    private static class Node implements Comparable<Node> {
        int a, b, cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++)
            elec.add(Integer.parseInt(st.nextToken()) - 1);

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            nodes.add(new Node(u, v, w));
        }

        Collections.sort(nodes);
        int minCost = 0;
        for (Node node : nodes) {
            if (union(node.a, node.b))
                minCost += node.cost;

            if (allUnion())
                break;
        }
        System.out.println(minCost);
    }

    private static boolean allUnion() {
        for (int parent : parents) {
            if (!elec.contains(parents[parent] = findParents(parent))) {
                return false;
            }
        }
        return true;
    }

    private static boolean union(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (elec.contains(a) && elec.contains(b) || a == b) return false;
        else if (elec.contains(a)) parents[b] = a;
        else parents[a] = b;
        return true;
    }

    private static int findParents(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = findParents(parents[a]);
    }
}
