package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11438_LCA2 {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] depth;
    private static int[][] parents;
    private static boolean[] visited;
    private static int maxDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int node = Integer.parseInt(br.readLine());

        for (int i = 0; i < node; i++) {
            graph.add(new ArrayList<>());
        }

        int temp = 1;
        maxDepth = 0;
        while (temp < node) {
            temp <<= 1;
            maxDepth++;
        }
        parents = new int[node][maxDepth];

        for (int i = 0; i < node - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        depth = new int[node];
        visited = new boolean[node];
        visited[0] = true;
        depth[0] = 0;
        findDepth(0);

        for (int i = 1; i < maxDepth; i++) {
            for (int j = 0; j < node; j++) {
                parents[j][i] = parents[parents[j][i - 1]][i - 1];
            }
        }
//        for (int i = 0; i < node; i++){
//            System.out.println(Arrays.toString(parents[i]));
//        }


        int qCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < qCnt; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(findLCA(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1) + 1);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int findLCA(int a, int b) {
        int depthA = depth[a];
        int depthB = depth[b];
        if (depthA < depthB) {
            int temp = a;
            a = b;
            b = temp; // A가 더 깊은걸로 설정
        }

        for (int i = maxDepth - 1; 0 <= i; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parents[a][i];
            }
        }

        if (a == b) return a;

        for (int i = maxDepth - 1; 0 <= i; i--) {
            if (parents[a][i] != parents[b][i]) {
                a = parents[a][i];
                b = parents[b][i];
            }
        }

        return parents[a][0];
    }


    private static void findDepth(int now) {
        for (Integer integer : graph.get(now)) {
            if (!visited[integer]) {
                visited[integer] = true;
                depth[integer] = depth[now] + 1;
                parents[integer][0] = now;
                findDepth(integer);
            }
        }
    }
}
