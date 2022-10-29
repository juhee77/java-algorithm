package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_2565_전깃줄 {
    private static int[][] map;
    private static boolean[] visited;
    private static int cnt = Integer.MAX_VALUE;

    private static void dfs(int n, int d,int start ) {
        if (d >= n) {
            cnt = d;
            return;
        }

        if (isCross()) {
            for (int i = start; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(n, d + 1,i);
                    visited[i] = false;
                }
            }
        }
        else {
            cnt = Math.min(cnt,d);
        }
    }


    private static boolean isCross() {
        int before = 0;
        for (int i = 0; i < map.length; i++) {
            if (visited[i]) continue;
            if (before > map[i][1]) return true;
            before = map[i][1];
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        map = new int[line][2];
        visited = new boolean[line];

        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, Comparator.comparingInt(o -> o[0]));

        if (!isCross()) System.out.println(0);
        else {
            dfs(line, 0,0);
            System.out.println(cnt);
        }
    }
}
