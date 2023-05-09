package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3055_탈출 {
    private static char[][] map;
    private static int row, col;
    private static Point start;
    private static final Queue<Point> waters = new LinkedList<>();
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 'S') start = new Point(i, j);
                else if (map[i][j] == '*') waters.add(new Point(i, j));
            }

        }
        int ans = bfs();
        System.out.println(ans == -1 ? "KAKTUS" : ans);
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        boolean[][] visited = new boolean[row][col];
        visited[start.x][start.y] = true;

        int depth = 0;
        while (!q.isEmpty()) {
            depth++;

            //물이 이동
            int size = waters.size();
            for (int i = 0; i < size; i++) {
                Point nowWater = waters.poll();

                for (int[] dir : dirs) {
                    int mvx = nowWater.x + dir[0];
                    int mvy = nowWater.y + dir[1];
                    if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) continue;//범위를 벗어남
                    if (map[mvx][mvy] == '.') { //빈칸인 경우에만
                        waters.add(new Point(mvx, mvy));
                        map[mvx][mvy] = '*';
                    }
                }
            }


            size = q.size();
            //고슴도치 이동
            for (int i = 0; i < size; i++) {
                Point dochi = q.poll();

                for (int[] dir : dirs) {
                    int mvx = dochi.x + dir[0];
                    int mvy = dochi.y + dir[1];

                    if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) continue;//범위를 벗어남
                    if (map[mvx][mvy] == 'D') return depth;
                    if (map[mvx][mvy] == '.' && !visited[mvx][mvy]) { //빈칸이고 방문되지 않은
                        q.add(new Point(mvx, mvy));
                        visited[mvx][mvy] = true;
                    }
                }
            }
        }
        return -1;

    }


    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
