package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_6087_레이저통신 {
    private static int row, col;
    private static char[][] map;
    private static boolean[][][] visited;
    private static int startCX, startCY;
    private static final int[] dirx = {-1, 1, 0, 0}; //위 아래 오 왼
    private static final int[] diry = {0, 0, 1, -1};
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        visited = new boolean[row][col][4];

        for (int i = 0; i < row; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp[j];
                if (temp[j] == 'C') {
                    startCX = i;
                    startCY = j;
                }
            }
        }

        bfs();
        System.out.println(min);
    }

    private static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.min));
        for (int i = 0; i < 4; i++) {
            queue.add(new Point(startCX, startCY, 0, i));
        }

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            //System.out.println(now + " " + map[now.x][now.y] + " " + now.min);
            visited[now.x][now.y][now.dir] = true;

            if (map[now.x][now.y] == 'C' && !(now.x == startCX && now.y == startCY)) {
                min = Math.min(min, now.min);
                continue;
            }


            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dirx[i];
                int mvy = now.y + diry[i];
                if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) continue;
                if (map[mvx][mvy] == '*') continue;
                if (visited[mvx][mvy][i]) continue;

                if (i == now.dir) {
                    queue.add(new Point(mvx, mvy, now.min, i));
                } else {
                    queue.add(new Point(mvx, mvy, now.min + 1, i));
                }
            }
        }
    }

    private static class Point {
        int x, y, min, dir;

        public Point(int x, int y, int min, int dir) {
            this.x = x;
            this.y = y;
            this.min = min;
            this.dir = dir;
        }

    }

}
