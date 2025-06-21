package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_10451_순열사이클 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            parents = new int[n];
            for (int i = 0; i < n; i++)
                parents[i] = i;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                union(i, Integer.parseInt(st.nextToken()) - 1);

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(findParents(i));
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }

    public static void union(int u, int v) {
        int a = findParents(u);
        int b = findParents(v);
        if (a != b) {
            parents[b] = a;
        }
    }

    private static int findParents(int a) {
        if (parents[a] == a) return a;
        return parents[a] = findParents(parents[a]);
    }
}
