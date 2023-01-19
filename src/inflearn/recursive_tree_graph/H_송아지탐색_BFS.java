package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H_송아지탐색_BFS {
    private static int[] dirs = {1, -1, 5};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int nowLevel = getNowLevel(s, e);
        System.out.println(nowLevel);
    }

    private static int getNowLevel(int s, int e) {
        boolean[] visited = new boolean[10001];

        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        int nowLevel = 0;
        while (!q.isEmpty()) {
            if (q.contains(e)) {
                break;
            }
            nowLevel++;
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int now = q.poll();
                for (int dir : dirs) {
                    int moved = now + dir;
                    if (moved == e) return nowLevel;
                    if (0 <= dir && dir <= 10000 && !visited[moved]) {
                        visited[moved] = true;
                        q.add(moved);
                    }
                }
            }
        }
        return -1;
    }
}
