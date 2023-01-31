package inflearn.dfs_bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class K_미로탐색_bfs {
    private static int[][] map;
    private static final int SIZE = 7;
    private static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println("=== solution 1 ===");
        System.out.println(bfs());
        System.out.println("=== solution 2 ===");
        System.out.println(bfs2());
    }

    private static int bfs() {
        boolean[][] visited = new boolean[SIZE][SIZE];
        visited[0][0] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));
        int nowDepth = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point poll = q.poll();

                for (int[] ints : dir) {
                    int moveX = poll.x + ints[0];
                    int moveY = poll.y + ints[1];
                    if (moveX < 0 || moveY < 0 || SIZE <= moveX || SIZE <= moveY) continue;
                    if (moveX == SIZE - 1 && moveY == SIZE - 1) return nowDepth;
                    if (!visited[moveX][moveY] && map[moveX][moveY] == 0) {
                        visited[moveX][moveY] = true;
                        q.add(new Point(moveX, moveY));
                    }
                }
            }
            nowDepth++;
        }
        return -1;
    }

    private static int bfs2() {
        int[][] visited = new int[SIZE][SIZE];
        visited[0][0] = 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int[] ints : dir) {
                int moveX = poll.x + ints[0];
                int moveY = poll.y + ints[1];
                if (moveX < 0 || moveY < 0 || SIZE <= moveX || SIZE <= moveY) continue;
                if (moveX == SIZE - 1 && moveY == SIZE - 1) return visited[poll.x][poll.y];
                if (visited[moveX][moveY] == 0 && map[moveX][moveY] == 0) {
                    visited[moveX][moveY] = visited[poll.x][poll.y] + 1;
                    q.add(new Point(moveX, moveY));
                }
            }
        }
        return -1;
    }
}
