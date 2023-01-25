package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_합이같은부분집합_DFS_amazon_interview {
    private static boolean flag = false;
    static int n, total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        /*=== my ===*/
        flag = false;
        boolean[] visited = new boolean[n];
        dfs(0, n, visited, arr);
        System.out.println(getStatus());

        /*======*/
        flag = false;
        DFS(0, 0, arr);
        System.out.println(getStatus());
    }


    private static String getStatus() {
        if (flag) return "YES";
        return "NO";
    }

    private static void dfs(int nowDepth, int maxDepth, boolean[] visited, int[] arr) {
        if (flag) return;
        // 더해 나가면서 하는 방법도 있음
        // 그 경우에는 sum /2 한것 보다 큰 경우 버림
        if (nowDepth == maxDepth) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += arr[i];
                } else {
                    sum -= arr[i];
                }
            }
            if (sum == 0) flag = true;
            return;
        }
        visited[nowDepth] = true;
        dfs(nowDepth + 1, maxDepth, visited, arr);
        visited[nowDepth] = false;
        dfs(nowDepth + 1, maxDepth, visited, arr);
    }


    /**
     * solution
     */
    public static void DFS(int L, int sum, int[] arr) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == n) {
            if ((total - sum) == sum) {
                flag = true;
            }
        } else {
            DFS(L + 1, sum + arr[L], arr);
            DFS(L + 1, sum, arr);
        }
    }
}
