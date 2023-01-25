package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class F_순열 {
    private static boolean[] visited;
    private static int[] answer;
    private static int[] initNumber;

    static int[] permutation, check;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        initNumber = new int[n];
        for (int i = 0; i < n; i++) {
            initNumber[i] = Integer.parseInt(st.nextToken());
        }

        /*=== user *===*/
        visited = new boolean[n];
        answer = new int[m];
        dfs(0);
        System.out.println();
        System.out.println();

        /*== solution ==*/
        check = new int[n];
        permutation = new int[m];
        DFS(0);
    }


    private static void dfs(int depth) {
        if (depth == m) {
            for (int i : answer) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 0; i < initNumber.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = initNumber[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void DFS(int L) {
        if (L == m) {
            for (int x : permutation) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {// 방문 하지 않은 경우에만
                    check[i] = 1;
                    permutation[L] = initNumber[i];
                    DFS(L + 1);
                    check[i] = 0;
                }
            }
        }
    }
}
