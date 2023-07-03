package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2503_숫자야구 {
    private static int[] ans = new int[3];
    private static boolean[] visited = new boolean[10];
    private static int ableCnt = 0;
    private static String[] arr;
    private static int[][] cmds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new String[n];
        cmds = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            cmds[i][0] = Integer.parseInt(st.nextToken());
            cmds[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ableCnt);
    }

    public static void dfs(int depth) {
        if (depth == 3) {
            if (checkAble()) {
                ableCnt++;
            }
        } else {
            for (int i = 1; i < 10; i++) {
                if (visited[i]) continue;
                ans[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static boolean checkAble() {
        for (int i = 0; i < cmds.length; i++) {
            int ball = 0;
            int strike = 0;

            //ball
            for (int p = 0; p < 3; p++) {
                for (int q = 0; q < 3; q++) {
                    if (ans[p] + '0' == arr[i].charAt(q)) {
                        if (p == q) strike++;
                        else ball++;
                    }
                }
            }

            if (cmds[i][0] != strike || cmds[i][1] != ball) {
                return false;
            }
        }
        return true;
    }
}
