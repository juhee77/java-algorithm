package leetcode;

import java.util.ArrayList;
import java.util.List;

class FindIfPathExistsInGraph {
    int goal;
    boolean[] visited;
    List<List<Integer>> graph = new ArrayList<>();

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        goal = destination;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        visited[source] = true;
        return dfs(source);
    }

    private boolean dfs(int source) {
        boolean flag = false;
        for (Integer integer : graph.get(source)) {
            if (integer == goal)
                return true;

            if (!visited[integer]) {
                visited[integer] = true;
                flag |= dfs(integer);
                visited[integer] = false;
            }
        }
        return flag;
    }

    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;

        goal = destination;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        return dfs(source);
    }

    private boolean dfs2(int source) {
        if (source == goal) return true;
        visited[source] = true;

        for (Integer integer : graph.get(source)) {
            if (!visited[integer]) {
                if (dfs(integer)) {
                    return true;
                }
            }
        }
        return false;
    }
}