package leetcode;

import java.util.*;

class AllAncestorsOfANodeInADirectedAcyclicGraph_2192 {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] inDegree = new int[n];
        List<List<Integer>> nodes = new ArrayList<>();
        List<HashSet<Integer>> hashSets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
            hashSets.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            inDegree[edge[1]]++;
            nodes.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            Integer ancestor = q.poll();
//            System.out.println(ancestor + " " + nodes.get(ancestor));

            for (Integer next : nodes.get(ancestor)) {
                inDegree[next]--;
                hashSets.get(next).addAll(hashSets.get(ancestor));
                hashSets.get(next).add(ancestor);

                if (inDegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> integers = new ArrayList<>(hashSets.get(i));
            Collections.sort(integers);
            nodes.get(i).clear();
            nodes.get(i).addAll(integers);
        }
        return nodes;
    }


}