package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11437_LCA_Re {
    private static int[] depths;
    private static int[] parents;
    private static final List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int nodeCnt = Integer.parseInt(br.readLine());
        //부모 노드를 적는다.
        parents = new int[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //각 정점의 깊이를 구한다.
        depths = new int[nodeCnt];
        bfs();

        //두 정점의 같은 노드 구한다.
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            sb.append(lca(a, b)).append("\n");
        }
        System.out.println(sb);

    }

    private static int lca(int a, int b) {
        //일단 두 깊이가 같아 질때까지 끌어올린다.
        if (depths[a] > depths[b]) {
            //a를 끌어 올린다.
            while (depths[a] != depths[b]) {
                a = parents[a];
            }

        } else if (depths[a] < depths[b]) {
            //b를 끌어 올린다.
            while (depths[a] != depths[b]) {
                b = parents[b];
            }
        }

        //두 노드를 같이 올린다.
        while (a != b) {
            a = parents[a];
            b = parents[b];
        }

        return a + 1;
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int level = 1;
        depths[0] = level;
        parents[0] = 0;

        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer parent = q.poll();
                for (Integer child : graph.get(parent)) {
                    if (depths[child] == 0) { //방문하지 않은 경우
                        depths[child] = level;
                        parents[child] = parent;
                        q.add(child);
                    }
                }
            }
        }
    }

}
