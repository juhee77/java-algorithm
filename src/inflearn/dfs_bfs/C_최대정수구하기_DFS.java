package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_최대정수구하기_DFS {
    private static int problemCnt;
    private static int timeLimit;
    private static int[][] arr;
    private static boolean[] visited;
    private static int max;

    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        problemCnt = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());

        /*=== my === */
        arr = new int[problemCnt][2];
        visited = new boolean[timeLimit];
        for (int i = 0; i < problemCnt; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); //문제를 풀고 얻는 점수
            arr[i][1] = Integer.parseInt(st.nextToken());//푸는데 걸리는 시간
        }
        max = 0;
        dfs(0, timeLimit);
        System.out.println(max);

        /* === solution === */
        int[] a = new int[problemCnt];
        int[] b = new int[problemCnt];
        for (int i = 0; i < problemCnt; i++) {
            a[i] = arr[i][0];
            b[i] = arr[i][1];
        }
        DFS(0, 0, 0, a, b);
        System.out.println(answer);
    }

    private static void dfs(int depth, int remainTime) {
        if (depth == problemCnt) {
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sum += arr[i][0];
                }
            }
            max = Math.max(max, sum);
            return;
        }
        //문제를 풀 시간이 있는 경우에만
        if (arr[depth][1] <= remainTime) {
            visited[depth] = true;
            dfs(depth + 1, remainTime - arr[depth][1]);
        }
        visited[depth] = false;
        dfs(depth + 1, remainTime);
    }

    public static void DFS(int L, int sum, int time, int[] ps, int[] pt) {
        if (time > timeLimit) return;
        if (L == problemCnt) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + ps[L], time + pt[L], ps, pt);
            DFS(L + 1, sum, time, ps, pt);
        }
    }
}
