package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I_조합구하기 {
    private static boolean[] visited;
    private static int[] combination;
    private static int cn;
    private static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        cn = Integer.parseInt(st.nextToken());

        visited = new boolean[num];
        combination = new int[cn];
        System.out.println("1: I_조합구하기.dfs");
        dfs(1, 0);
        System.out.println("2: I_조합구하기.DFS");
        DFS(1, 0);
    }

    /**
     * visited 배열 없어도 된다. 그냥 외어 버리기
     */
    private static void DFS(int start, int depth) {
        if (depth == cn) {
            System.out.println(Arrays.toString(combination));
        } else {
            for (int i = start; i <= num; i++) {
                combination[depth] = i;
                dfs(i + 1, depth + 1);
            }
        }
    }

    private static void dfs(int start, int depth) {
        if (depth == cn) {
            System.out.println(Arrays.toString(combination));
        } else {
            for (int i = start; i <= num; i++) {
                if (!visited[i - 1]) {
                    visited[i - 1] = true;
                    combination[depth] = i;
                    dfs(i + 1, depth + 1);
                    visited[i - 1] = false;
                }
            }
        }
    }


}
