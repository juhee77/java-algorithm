package 백준.구현;

import java.io.*;
import java.util.*;

public class Boj_16947_서울지하철2호선 {

    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean[] isInCycle;
    static int[] distance;
    static boolean foundCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        isInCycle = new boolean[N];
        distance = new int[N];

        // 1. 사이클 탐색
        findCycle(0, -1, new Stack<>());

        // 2. BFS로 거리 계산
        bfsFromCycle();

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int d : distance) sb.append(d).append(" ");
        System.out.println(sb);
    }

    static boolean findCycle(int current, int parent, Stack<Integer> path) {
        visited[current] = true;
        path.push(current);

        for (int next : graph[current]) {
            if (next == parent) continue;

            if (visited[next]) {
                // 사이클 발견
                markCycle(path, next);
                return true;
            }

            if (findCycle(next, current, path)) return true;
        }

        path.pop();
        return false;
    }

    static void markCycle(Stack<Integer> path, int cycleStart) {
        foundCycle = true;
        boolean marking = false;

        for (int node : path) {
            if (node == cycleStart) marking = true;
            if (marking) isInCycle[node] = true;
        }
    }

    static void bfsFromCycle() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedBFS = new boolean[N];

        for (int i = 0; i < N; i++) {
            if (isInCycle[i]) {
                queue.offer(i);
                visitedBFS[i] = true;
                distance[i] = 0;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph[current]) {
                if (!visitedBFS[next]) {
                    visitedBFS[next] = true;
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
