package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16947_서울지하철2호선_ME {
    private static List<List<Integer>> graphs = new ArrayList<>();
    private static boolean[] visited;
    private static boolean[] isInCycle;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            graphs.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graphs.get(a).add(b);
            graphs.get(b).add(a);
        }

        visited = new boolean[N];
        isInCycle = new boolean[N];
        findCycle(0, -1, new ArrayList<>());

        distance = new int[N];
        foundDepth();

        for (int d : distance) {
            sb.append(d).append(" ");
        }
        System.out.println(sb);
    }

    //bfs
    private static void foundDepth() {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[graphs.size()];

        for (int i = 0; i < isInCycle.length; i++) {
            if (isInCycle[i]) {
                queue.add(i);
                visited[i] = true;
                distance[i] = 0;
            }
        }

        int tempDepth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (Integer child : graphs.get(current)) {
                    if (!visited[child]) {
                        distance[child] = tempDepth;
                        queue.add(child);
                        visited[child] = true;
                    }
                }
            }
            tempDepth++;
        }
    }

    //dfs
    private static boolean findCycle(int current, int parent, ArrayList<Integer> path) {
        visited[current] = true;
        path.add(current);

        for (Integer next : graphs.get(current)) {
            //방향 간선으로 부모는 무시한다.
            if (next == parent) continue;

            if (visited[next]) {
                //path내의 현재 노드가 시작한 위치부터 현재까지를 싸이클로 취급한다.
                coloredCycle(next, path);
                return true;
            }

            if(findCycle(next, current, path)) return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    private static void coloredCycle(Integer cycleStart, ArrayList<Integer> containsPath) {
        boolean marking = false;
        for (int node : containsPath) {
            if (cycleStart == node) marking = true;
            if (marking) isInCycle[node] = true;
        }
    }
}
