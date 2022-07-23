package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15649_backtracking {

    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;

    private static void dfs(int n, int m, int d) {
        if(d == m) {
            for(int a : arr) sb.append(a + " ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[d] = i;
                dfs(n, m, d+1);
                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        arr = new int[y]; visit = new boolean[x+1];
        dfs(x,y, 0);
        System.out.print(sb);

    }
}
