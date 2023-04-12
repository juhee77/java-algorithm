package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 방문 하는 모든 블럭의 경우를 생각한다.
 * 부서지는 경우에 따라서 만약 그전에 해당 칸에 방문했다면.. 하는 방법으로 처리한다.
 */
public class boj_14442_벽부수고이동하기 {
    private static int n, m, k;
    private static boolean[][][] visited;
    private static char[][] map;
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static class Point {
        int x, y, cost, freak;


        public Point(int x, int y, int cost, int freak) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.freak = freak;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    ", freak=" + freak +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][m][k + 1];
        System.out.println(bfs());
    }

    private static int bfs() {
        if (n == m && n == 1) return 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0));
        Arrays.fill(visited[n - 1][m - 1], true);
        while (!q.isEmpty()) {
            Point now = q.poll();
            System.out.println(now);
            for (int[] dir : dirs) {
                int movedX = now.x + dir[0];
                int movedY = now.y + dir[1];
                if (movedX < 0 || movedY < 0 || n <= movedX || m <= movedY) {
                    continue;
                }

                if (movedX == n - 1 && movedY == m - 1) return now.cost + 1;

                //벽을 부수고 가야하는 경우
                if (map[movedX][movedY] == '1') {
                    //만약 이미 부실수 있는 만큼 부신경우 지나간다.
                    if (now.freak == k) continue;
                    if (visited[movedX][movedY][now.freak + 1]) continue;//이미 방문함
                    q.add(new Point(movedX, movedY, now.cost + 1, now.freak + 1));
                    visited[movedX][movedY][now.freak + 1] = true;

                } else {
                    //벽이 없는 경우
                    if (visited[movedX][movedY][now.freak]) continue;
                    q.add(new Point(movedX, movedY, now.cost + 1, now.freak));
                    visited[movedX][movedY][now.freak] = true;
                }
            }
        }
        return -1;
    }
}
