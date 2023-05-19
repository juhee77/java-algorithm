package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_3584_공통조상찾기 {
    private static int[] depth;
    private static List<Integer>[] childGraph;
    private static int[] parents;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            parents = new int[n + 1];
            depth = new int[n + 1];
            childGraph = new List[n + 1];
            int[] parentGraph = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < n + 1; i++) {
                parents[i] = i;
                childGraph[i] = new ArrayList<>();
            }

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                childGraph[parent].add(child);
                parentGraph[child]++;
            }

            for (int i = 1; i < n + 1; i++) {
                if (parentGraph[i] == 0) {
                    visited[i] = true;
                    eachDepth(i, 0);
                }
            }


            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b)).append("\n");

        }

        System.out.println(sb);
    }

    private static int findLCA(int a, int b) {
        int depthA = depth[a], depthB = depth[b];
        if (depthA > depthB) {
            int temp = a;
            a = b;
            b = temp; // b가 더 깊도록 한다.
            temp = depthA;
            depthA = depthB;
            depthB = temp;
        }

        //b를 현재 깊이 까지 올린다. (A와 같도록 올린다) -- 부모노드로 올라가면서
        while (depthA < depthB) {
            b = parents[b];
            depthB = depth[b];
        }

        //이제 공통으로 찾아 간다.
        if (a == b) return a;

        while (a != b) {
            a = parents[a];
            b = parents[b];
        }

        return a;
    }

    private static void eachDepth(int now, int nowDepth) {
        depth[now] = nowDepth;
        for (Integer child : childGraph[now]) {
            if (visited[child]) continue;
            visited[child] = true;
            parents[child] = now;
            eachDepth(child, nowDepth + 1);
        }
    }
}
