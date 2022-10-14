package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1520_내리막길_bfspq {
    private static int[][] visited;
    private static int[][] map;
    private static int row = 0, col = 0;
    private static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static PriorityQueue<Point> queue = new PriorityQueue<>();

    private static class Point implements Comparable<Point> {
        int x, y, cs;

        public Point(int x, int y, int cs) {
            this.x = x;
            this.y = y;
            this.cs = cs;
        }


        @Override
        public int compareTo(Point o) {
            if (o.cs == this.cs) return 0;
            if (o.cs > this.cs) return 1;
            else return -1;
        }
    }

    private static int bfs() {

        queue.offer(new Point(0, 0, map[0][0]));
        visited[0][0] = 1;
        while (!queue.isEmpty()) {

            Point now = queue.poll();
            int nowh = map[now.x][now.y];

            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dir[i][0];
                int mvy = now.y + dir[i][1];

                if (row <= mvx || mvx < 0 || col <= mvy || mvy < 0) continue;//범위를 벗어남

                if (nowh <= map[mvx][mvy]) continue; // 더 높음

                if (visited[mvx][mvy] == 0) {
                    queue.add(new Point(mvx, mvy, map[mvx][mvy]));
                }
                visited[mvx][mvy] += visited[now.x][now.y];
            }

//            System.out.println();
//            for (int i = 0; i < row; i++) {
//                System.out.println(Arrays.toString(visited[i]));
//            }
        }

        return visited[row - 1][col - 1];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
}
