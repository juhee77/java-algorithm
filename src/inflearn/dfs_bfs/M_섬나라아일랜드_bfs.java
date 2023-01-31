package inflearn.dfs_bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class M_섬나라아일랜드_bfs {
    private static int[][] map;
    private static int size;
    private static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    /**
     * visit 배열이 없어도 된다.
     * 대신에 섬을 바다로 만드는걸로 방문처리를 대신함
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution());
    }

    private static int solution() {
        int ans = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        map[x][y] = 0;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            for (int[] ints : dir) {
                int moveX = poll.x + ints[0];
                int moveY = poll.y + ints[1];
                if (moveX < 0 || moveY < 0 || size <= moveX || size <= moveY) continue;
                if (map[moveX][moveY] == 1) {
                    map[moveX][moveY] = 0;
                    q.add(new Point(moveX, moveY));
                }
            }
        }

    }
}
