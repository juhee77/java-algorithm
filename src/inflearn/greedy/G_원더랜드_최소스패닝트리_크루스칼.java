package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class G_원더랜드_최소스패닝트리_크루스칼 {
    private static class Node implements Comparable<Node> {
        int start, end, cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        int ans = 0;
        parents = new int[v];
        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }

        Collections.sort(list);
        int edgeCnt  = 0; //
        for (Node node : list) {
            //세다가 만약 v-1이 되면 멈춘다.
            int findA = findParents(node.start);
            int findB = findParents(node.end);

            if (findA == findB) continue;
            ans += node.cost;
            edgeCnt++;//
            if(edgeCnt==v-1)break; // 간선개수가 많을때 필요없는 간선을 돌아야 경우가 있음, 정점은 v개 이므로 어차피 연결된 간선은 v-1개여서
            unionSet(findA, findB);
        }
        System.out.println(ans);
    }

    private static int findParents(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findParents(parents[x]);
    }

    private static void unionSet(int a, int b) {
        a = findParents(a);
        b = findParents(b);

        if (a < b) parents[b] = a;
        else parents[a] = b;
    }
}
