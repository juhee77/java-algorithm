package leetcode;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Queue;

class NumberOfIslands {
    private static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int landCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    findLands(i, j, grid);
                    landCnt++;
                }
            }
        }
        return landCnt;
    }

    private void findLands(int i, int j, char[][] grid) {
        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(i, j));

        while (!points.isEmpty()) {
            Point poll = points.poll();
            for (int[] dir : dirs) {
                int mvX = dir[0] + poll.x;
                int mvY = dir[1] + poll.y;
                if (mvX < 0 || grid.length <= mvX || mvY < 0 || grid[0].length <= mvY) {
                    continue;
                }

                if (grid[mvX][mvY] == '1') {
                    grid[mvX][mvY] = '2';
                    points.add(new Point(mvX, mvY));
                }
            }
        }
    }
}