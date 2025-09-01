package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1743_음식물피하기 {
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());

        char[][] map = new char[row][col];
        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            map[r][c] = '#';
        }

        int max = 0;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == '#') {
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i, j));
                    visited[i][j] = true;
                    int size = 1;

                    while (!queue.isEmpty()) {
                        Point poll = queue.poll();

                        for (int[] dir : dirs) {
                            int mvx = dir[0] + poll.x;
                            int mvy = dir[1] + poll.y;

                            if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) continue;
                            if (map[mvx][mvy] == '#' && !visited[mvx][mvy]) {
                                visited[mvx][mvy] = true;
                                size++;
                                queue.add(new Point(mvx, mvy));
                            }
                        }

                    }
                    max = Math.max(size, max);
                }
            }
        }
        System.out.println(max);

    }
}
