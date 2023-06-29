package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1189_컴백홈 {
    private static final int[] dirX = {0, 0, -1, 1};
    private static final int[] dirY = {-1, 1, 0, 0};

    private static char[][] map;
    private static boolean[][] visited;
    private static int r, c, k;
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int depth) {
        if (x == 0 && y == c - 1 && depth == k) {
            cnt++;
        }

        if (k <= depth) return; //더 이상 탐색하는것이 의미가 없음

        for (int i = 0; i < 4; i++) {
            int mvx = x + dirX[i];
            int mvy = y + dirY[i];

            if (mvx < 0 || mvy < 0 || r <= mvx || c <= mvy || visited[mvx][mvy]) continue;//범위를 넘어가거나, 이미 방문함
            if (map[mvx][mvy] == 'T') continue;

            visited[mvx][mvy] = true;
            dfs(mvx, mvy, depth + 1);
            visited[mvx][mvy] = false;
        }
    }
}
