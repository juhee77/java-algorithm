package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2468_bfs {
    private static int[][] map;
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};

    private static boolean[][] visited;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        int maxCityHeight = 0;
        int minCityHeight = 101;
        int areaMaxCount = 1;

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxCityHeight = Math.max(map[i][j], maxCityHeight);
                minCityHeight = Math.min(map[i][j], minCityHeight);
            }
        }

        for (int rainHeight = minCityHeight; rainHeight < maxCityHeight; rainHeight++) {
            areaMaxCount = Math.max(areaMaxCount, checkingMax(rainHeight));
        }
        System.out.println(areaMaxCount);
    }

    private static int checkingMax(int rainH) {
        int areaCount = 0;
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > rainH && !visited[i][j]) {
                    bfs(i, j, rainH);
                    areaCount++;
                }
            }
        }
        return areaCount;
    }

    private static void bfs(int x, int y, int rainH) {
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dirX[i];
                int mvy = now.y + dirY[i];
                if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy) continue;
                if (map[mvx][mvy] > rainH && !visited[mvx][mvy]) {
                    visited[mvx][mvy] = true;
                    queue.add(new Point(mvx, mvy));
                }
            }
        }

    }
}
