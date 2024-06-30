package leetcode;

class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable_1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;

        int removeCnt = getRemoveCnt(edges, 3, parents);
        removeCnt += getRemoveCnt(edges, 1, parents.clone());
        removeCnt += getRemoveCnt(edges, 2, parents.clone());

        //System.out.println(removeCnt);
        return (removeCnt >= 0) ? removeCnt : -1;
    }

    private int getRemoveCnt(int[][] edges, int x, int[] parents) {
        int removeCnt = 0;
        for (int[] edge : edges) {
            if (edge[0] == x) {
                if (!union(parents, edge[1] - 1, edge[2] - 1)) {
                    removeCnt++;
                }
            }
        }

        //System.out.println(Arrays.toString(parents));
        if (x == 1 || x == 2) {
            for (int i = 0; i < parents.length; i++) {
                if (find(parents, i) != 0)
                    return -10000000;
            }
        }
        return removeCnt;
    }

    public boolean union(int[] parents, int a, int b) {
        a = find(parents, a);
        b = find(parents, b);

        if (a == b) return false;

        if (a < b) parents[b] = a;
        else parents[a] = b;
        return true;
    }

    public int find(int[] parents, int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents, parents[x]);
    }
}