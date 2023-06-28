package 백준.graph.unionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_2668_숫자고르기2 {
    private static int[] arr;
    private static boolean[] visit;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(i, i);
            visit[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (Integer integer : list) {
            sb.append(integer + 1).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int goal) {
        if (!visit[arr[start]]) {
            visit[arr[start]] = true;
            dfs(arr[start], goal);
            visit[arr[start]] = false;
        }
        if (arr[start] == goal) list.add(start);
    }
}
