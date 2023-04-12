package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * visit배열에 현재까신 부신 벽의 개수를 적는다
 * 현재 부서진 입력값보다 적으면 해당 블럭을 방문하고 아니면 그냥 지나간다.
 */
public class boj_14442_벽부수고이동하기_refactor {
    private static int n, m, k;
    private static int[][] visited;
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
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        if (n == m && n == 1) return 1;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1, 0));
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
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
                    if (visited[movedX][movedY] <= now.freak + 1) continue;//이미 방문 함
                    q.add(new Point(movedX, movedY, now.cost + 1, now.freak + 1));
                    visited[movedX][movedY] = now.freak + 1;

                } else {
                    //벽이 없는 경우
                    if (visited[movedX][movedY] <= now.freak) continue;
                    q.add(new Point(movedX, movedY, now.cost + 1, now.freak));
                    visited[movedX][movedY] = now.freak;
                }
            }
        }
        return -1;
    }
}
