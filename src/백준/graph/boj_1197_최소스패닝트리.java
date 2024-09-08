package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1197_최소스패닝트리 {
    private static int[] parents;
    private static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        private int distance;
        private int nodeA;
        private int nodeB;

        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    private static int findParent(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findParent(parents[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parents[b] = a;
        else parents[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;

        int v = Integer.parseInt(st.nextToken());// 정점
        int e = Integer.parseInt(st.nextToken()); // 간선

        parents = new int[v + 1];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }
        //edge 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(c, a, b));
        }
        Collections.sort(edges);

        for (Edge edge : edges) {
            int cost = edge.distance;
            int a = edge.nodeA;
            int b = edge.nodeB;
            //사이클이 발생하지 않는 경우에만 집합에 포함
            if (findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }

        System.out.println(result);
    }
}

/*
5 4
1 2 -2147483648
2 3 2147483647
1 4  2147483647
5 4  2147483647
 */