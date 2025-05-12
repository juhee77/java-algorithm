package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2150_StronglyConnectedComponent_Scc {
    static ArrayList<Integer>[] graph, reverseGraph;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<ArrayList<Integer>> sccList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        reverseGraph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            reverseGraph[to].add(from);
        }

        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) dfs(i);
        }

        visited = new boolean[V + 1];
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                ArrayList<Integer> component = new ArrayList<>();
                reverseDfs(node, component);
                Collections.sort(component);
                sccList.add(component);
            }
        }

        sccList.sort((a, b) -> a.get(0) - b.get(0));
        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size()).append("\n");
        for (ArrayList<Integer> scc : sccList) {
            for (int node : scc) {
                sb.append(node).append(" ");
            }
            sb.append("-1\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) dfs(next);
        }
        stack.push(node);
    }

    static void reverseDfs(int node, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int next : reverseGraph[node]) {
            if (!visited[next]) reverseDfs(next, component);
        }
    }
}
