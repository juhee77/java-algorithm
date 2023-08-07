package 백준.구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_11559_PuyoPuyo {
    private static char[][] map = new char[12][6];
    private static boolean[][] visited;
    private static final int[] dirX = {0, 0, -1, 1};
    private static final int[] dirY = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        while (true) {
            if (popPyuo()) {
                map = gravity();
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);

    }

    private static char[][] gravity() {
        char[][] tempMap = new char[12][6];
        for (int i = 0; i < 12; i++) {
            Arrays.fill(tempMap[i], '.');
        }
        //세로로 각 한줄씩
        //아래에서 위로
        for (int i = 0; i < 6; i++) {
            int nowIndex = 11;
            for (int j = 11; 0 <= j; j--) {
                if (map[j][i] != '.')
                    tempMap[nowIndex--][i] = map[j][i];
            }
        }
        return tempMap;
    }

    private static boolean popPyuo() {
        //밑에서 부터 확인한다.
        boolean isPop = false;
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.') {
                    int blockCnt = bfs(new Point(i, j), false);
                    if (4 <= blockCnt) {
                        bfs(new Point(i, j), true);
                        isPop = true;
                    }
                }
            }
        }
        return isPop;
    }

    private static int bfs(Point start, boolean isPop) {
        visited = new boolean[12][6];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;
        char color = map[start.x][start.y];
        if (isPop) map[start.x][start.y] = '.';
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int mvx = poll.x + dirX[i];
                int mvy = poll.y + dirY[i];

                if (mvx < 0 || mvy < 0 || 12 <= mvx || 6 <= mvy || visited[mvx][mvy]) continue;
                if (map[mvx][mvy] == color) {
                    queue.add(new Point(mvx, mvy));
                    visited[mvx][mvy] = true;
                    if (isPop) map[mvx][mvy] = '.';
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
