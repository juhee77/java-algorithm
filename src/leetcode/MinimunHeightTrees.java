package leetcode;

import java.util.*;

class MinimunHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();

        if (n <= 0) return result;
        if (n == 1) {
            result.add(0);
            return result;
        }

        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            int size = leaves.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                int parent = graph.get(leaf).iterator().next();
                graph.get(parent).remove(leaf);
                if (graph.get(parent).size() == 1) {
                    leaves.add(parent);
                }
            }
        }

        while (!leaves.isEmpty()) {
            result.add(leaves.poll());
        }

        return result;
    }
}
