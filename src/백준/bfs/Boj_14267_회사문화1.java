package 백준.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14267_회사문화1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] score = new int[n];
        int[] ans = new int[n];
        int root = -1;
        List<List<Integer>> downGraph = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            downGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken()) - 1;
            if (parent == -2) {
                root = i;
                continue;
            }
            downGraph.get(parent).add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken()) - 1;
            int tempScore = Integer.parseInt(st.nextToken());
            score[index] += tempScore;
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{root, score[root]}); //부모, 전이되는 점수
        ans[root] = score[root];

        while (!q.isEmpty()) {
            int[] parent = q.poll();

            for (Integer child : downGraph.get(parent[0])) {
                ans[child] += parent[1];
                q.add(new int[]{child, score[child] + ans[child]});
                ans[child] += score[child];
            }
        }

        for (int el : ans) {
            sb.append(el).append(" ");
        }
        System.out.println(sb);
    }
}
