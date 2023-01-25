package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_바둑이승차_DFS {
    private static int c;
    private static int n;
    private static int[] arr;
    private static boolean[] visited;
    private static int max = 0;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());


        /*=== my ===*/
        arr = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        dfs(0);
        System.out.println(max);


        /* =========== */
        DFS(0, 0, arr);
        System.out.println(answer);
    }

    private static void dfs(int nowDepth) {
        if (nowDepth == n) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += arr[i];
                    if (c < sum) return;
                }
            }
            max = Math.max(max, sum);
            return;
        }
        visited[nowDepth] = true;
        dfs(nowDepth + 1);
        visited[nowDepth] = false;
        dfs(nowDepth + 1);

    }

    /**
     * solution
     */
    public static void DFS(int L, int sum, int[] arr) {
        if (sum > c) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }
}
