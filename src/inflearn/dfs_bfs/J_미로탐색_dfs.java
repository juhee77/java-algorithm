package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_미로탐색_dfs {
    private static int[][] map;
    private static boolean[][] visited;
    private static int ans = 0;
    private static final int SIZE = 7;
    private static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        dfs(0, 0);
        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        if (x == SIZE - 1 && y == SIZE - 1) {
            ans++;
            return;
        }

        for (int[] ints : dir) {
            int moveX = x + ints[0];
            int moveY = y + ints[1];
            if (moveX < 0 || moveY < 0 || SIZE <= moveX || SIZE <= moveY || map[moveX][moveY] == 1) continue;
            if (!visited[moveX][moveY]) {
                visited[moveX][moveY] = true;
                dfs(moveX, moveY);
                visited[moveX][moveY] = false;
            }
        }
    }
}
