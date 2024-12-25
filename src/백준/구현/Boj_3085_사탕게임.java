package 백준.구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj_3085_사탕게임 {
    private static int n;
    private static char[][] map;
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        int max = 0;
        for (int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(map[i][j], i, j, 0));
                max = Math.max(max, dfs(map[i][j], i, j, 2));

                //가로
                if (j + 1 < n && map[i][j] != map[i][j + 1]) {
                    swap(i, i, j, j + 1);
                    max = Math.max(max, dfs(map[i][j], i, j, 0));
                    max = Math.max(max, dfs(map[i][j], i, j, 2));
                    max = Math.max(max, dfs(map[i][j + 1], i, j + 1, 0));
                    max = Math.max(max, dfs(map[i][j + 1], i, j + 1, 2));
                    swap(i, i, j + 1, j);
                }

                //세로
                if (i + 1 < n && map[i][j] != map[i + 1][j]) {
                    swap(i, i + 1, j, j);
                    max = Math.max(max, dfs(map[i][j], i, j, 0));
                    max = Math.max(max, dfs(map[i][j], i, j, 2));
                    max = Math.max(max, dfs(map[i + 1][j], i + 1, j, 0));
                    max = Math.max(max, dfs(map[i + 1][j], i + 1, j, 2));
                    swap(i + 1, i, j, j);
                }
            }
        }
        System.out.println(max);

    }

    private static void swap(int i, int i1, int j, int j1) {
        char temp = map[i][j];
        map[i][j] = map[i1][j1];
        map[i1][j1] = temp;
    }

    private static int dfs(char c, int i, int j, int findScope) {
        boolean[][] visited = new boolean[n][n];
        visited[i][j] = true;

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(i, j));

        int depth = 1;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int x = findScope; x < findScope + 2; x++) {
                int[] dir = dirs[x];
                int mvX = poll.x + dir[0];
                int mvY = poll.y + dir[1];

                if (n <= mvX || n <= mvY || mvY < 0 || mvX < 0 || map[mvX][mvY] != c || visited[mvX][mvY]) continue;

                visited[mvX][mvY] = true;
                queue.add(new Point(mvX, mvY));
                depth++;
            }
        }
        return depth;
    }
}
