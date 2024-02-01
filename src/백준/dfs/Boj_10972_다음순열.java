package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10972_다음순열 {
    private static int n;
    private static int[] ans;
    private static int[] returnAns;
    private static int[] now;
    private static boolean[] visited;
    private static boolean flag = false, find = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        now = new int[n];
        visited = new boolean[n];
        returnAns = new int[n];

        int point = n;
        for (int i = 0; i < n; i++) {
            if (ans[i] == point) {
                now[i] = point;
                visited[point - 1] = true;
                point--;
            } else {
                break;
            }
        }

        System.out.println(n - point);
        dfs(n - point);

        if (!find || point == 0) {
            System.out.println(-1);
        } else {
            for (int returnAn : returnAns) {
                sb.append(returnAn).append(" ");
            }
            System.out.println(sb);
        }
    }

    private static void dfs(int depth) {
        if (depth == n) {
            if (flag) {
                returnAns = now;
                find = true;
                return;
            }
            if (isSame(ans, now)) {
                flag = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                now[depth] = i;
                dfs(depth + 1);
                if (find) return;
                visited[i - 1] = false;
            }
        }

    }

    private static boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
