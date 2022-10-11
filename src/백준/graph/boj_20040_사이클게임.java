package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_20040_사이클게임 {
    private static int v, e, parents[];
    private static ArrayList<Edge> edges = new ArrayList<>();

    static class Edge {
        private int nodeA;
        private int nodeB;

        public Edge(int nodeA, int nodeB) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
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

        v = Integer.parseInt(st.nextToken());// 정점
        e = Integer.parseInt(st.nextToken()); // 간선

        parents = new int[v];
        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }
        //edge 입력
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a,b));
        }

        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).nodeA;
            int b = edges.get(i).nodeB;
            if (findParent(a) == findParent(b)) {
                result=i+1;
                break;
            }
            else unionParent(a, b);
        }

        System.out.println(result);
    }

}
