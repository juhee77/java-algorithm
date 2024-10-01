package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1325_효율적인해킹 {
    private static ArrayList<Integer>[] inGraph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        inGraph = new ArrayList[n+1];

        for (int i = 0; i < n + 1; i++) {
            inGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inGraph[b].add(a);
        }

        int[] holdCnt = new int[n + 1];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            holdCnt[i] = getCnt(n, i);
            max = Math.max(max, holdCnt[i]);
        }
//        System.out.println(Arrays.toString(holdCnt));

        for (int i = 1; i <= n; i++) {
            if (holdCnt[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int getCnt(int n, int i) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        queue.offer(i);
        visited[i] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Integer parent = queue.poll();
            cnt++;

            for (Integer child : inGraph[parent]) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.offer(child);
                }
            }
        }
        return cnt;
    }
}
