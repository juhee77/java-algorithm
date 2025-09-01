package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_3184_양 {
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int wolf = 0, sheep = 0;
        char[][] map = new char[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] != '#' && !visited[i][j]) {
                    visited[i][j] = true;
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i, j));
                    int tempS = 0, tempW = 0;
                    if (map[i][j] == 'v') tempW++;
                    else if (map[i][j] == 'o') tempS++;

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            Point poll = queue.poll();
                            for (int[] dir : dirs) {
                                int mvx = poll.x + dir[0];
                                int mvy = poll.y + dir[1];

                                if (mvx < 0 || mvy < 0 || r <= mvx || c <= mvy || visited[mvx][mvy] || map[mvx][mvy] == '#')
                                    continue;

                                visited[mvx][mvy] = true;
                                queue.add(new Point(mvx, mvy));
                                if (map[mvx][mvy] == 'v') tempW++;
                                else if (map[mvx][mvy] == 'o') tempS++;
                            }
                        }
                    }
                    if (tempS <= tempW) wolf += tempW;
                    else sheep += tempS;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }
}
