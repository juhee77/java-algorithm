package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_친구인가_UnionFind {
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            int aParents = findParents(a);
            int bParents = findParents(b);

            unionParents(aParents, bParents);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken())-1;
        int b = Integer.parseInt(st.nextToken())-1;

        if (findParents(a) != findParents(b)) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static void unionParents(int a, int b) {
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
        } else return parents[x] = findParents(parents[x]);//경로 압축
    }
}
