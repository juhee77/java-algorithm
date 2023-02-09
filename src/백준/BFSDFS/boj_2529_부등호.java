package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2529_부등호 {
    private static char[] suffix;
    private static final boolean[] visited = new boolean[10];
    private static long max = Long.MIN_VALUE;
    private static long min = Long.MAX_VALUE;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        suffix = new char[n];
        for (int i = 0; i < n; i++) {
            suffix[i] = st.nextToken().charAt(0);
        }

        dfs(0, 0L);
        sb.append(max).append("\n");
        if (min < Math.pow(10, n)) sb.append("0").append(min);
        else sb.append(min);
        System.out.println(sb);
    }

    private static void dfs(int nowDepth, long nowNum) {

        if (nowDepth == n + 1) {
            min = Math.min(nowNum, min);
            max = Math.max(nowNum, max);
            return;
        }
        if (nowDepth == 0) {
            madeNum(nowDepth, nowNum, 0, 10);
            return;
        }

        int beforeNum = (int) (nowNum % 10);
        if (suffix[nowDepth - 1] == '<') {
            madeNum(nowDepth, nowNum, beforeNum + 1, 10);
        } else { //'>'
            madeNum(nowDepth, nowNum, 0, beforeNum);
        }
    }

    private static void madeNum(int nowDepth, long nowNum, int start, int end) {
        for (int i = start; i < end; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(nowDepth + 1, nowNum * 10 + i);
                visited[i] = false;
            }
        }
    }
}
