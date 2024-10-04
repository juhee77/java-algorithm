package 백준.graph.mst.kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_13905_세부 {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        List<int[]> edges = new ArrayList<>();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            edges.add(new int[]{a, b, distance});
        }

        Collections.sort(edges, (o1, o2) -> o2[2] - o1[2]);

        int mstCnt = 0;
        int min = Integer.MAX_VALUE;
        boolean find = false;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) {
                mstCnt++;
                min = Math.min(min, edge[2]);
            }

            if (mstCnt == n - 1 || findParent(start) == findParent(end)) {
                find = true;
                break;
            }
        }
        System.out.println(find ? min : 0);
    }

    private static boolean union(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a == b) return false;

        if (a < b) parents[b] = a;
        else parents[a] = b;
        return true;
    }

    private static int findParent(int x) {
        if (x == parents[x]) return x;
        return parents[x] = findParent(parents[x]);
    }
}
