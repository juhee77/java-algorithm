package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4485_BFS {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int size;
    private static int[][] map;
    private static final int INF = (int) 1e9;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int proCount = 1;

        while ((size = Integer.parseInt(br.readLine())) != 0) {
            map = new int[size][size];

            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(proCount++).append(": ").append(bfs(0, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int startX, int startY) {
        int[][] distance = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(distance[i], INF);
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));
        distance[startX][startY] = map[startX][startY];

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dir[i][0];
                int mvy = now.y + dir[i][1];
                if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy) continue;

                int tempDistance = distance[now.x][now.y] + map[mvx][mvy];
                if (tempDistance < distance[mvx][mvy]) {
                    distance[mvx][mvy] = tempDistance;
                    q.add(new Point(mvx, mvy));
                }
            }
        }
        return distance[size - 1][size - 1];
    }
}
