package 백준.dynamicProgramming.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1949_우수마을 {
    private static final List<List<Integer>> graph = new ArrayList<>();
    private static int[] arr;
    private static int[][] dp;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dp = new int[n][2]; //0 일반, 1 우수
        visited = new boolean[n];
        visited[0] = true;
        dfs(0);

        System.out.println(Math.max(dp[0][1], dp[0][0]));
    }

    private static void dfs(int nowNode) {
        dp[nowNode][1] = arr[nowNode];

        for (Integer nextNode : graph.get(nowNode)) {
            if (visited[nextNode]) {
                continue;
            }

            visited[nextNode] = true;
            dfs(nextNode);
            //만약 이번이 우수 도시라면 //이후 도시는 우수도시가 아니여야 한다.
            dp[nowNode][1] += dp[nextNode][0];
            //만약 이번이 우수도시가 아니라면 다음노드는 우수도시이거나 우수도시가 아니여도 된다.
            dp[nowNode][0] += Math.max(dp[nextNode][0], dp[nextNode][1]);
        }

    }
}
