package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1325_효율적인해킹 {
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    static int n, m;
    static int count;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        int[] cnt = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            count = 0;
            bfs(i);
            cnt[i] = count;
            max = Math.max(count, max);

        }
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == max)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i : graph.get(v)) {
                if (!visit[i]) {
                    visit[i] = true;
                    count++;
                    q.add(i);
                }
            }
        }
    }
}