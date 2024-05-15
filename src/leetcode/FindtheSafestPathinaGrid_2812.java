package leetcode;

import java.util.*;

public class FindtheSafestPathinaGrid_2812 {
    final int[] dy = {-1, 0, 1, 0};
    final int[] dx = {0, 1, 0, -1};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < n; ++x) {
                if (grid.get(y).get(x) == 1) {
                    q.offer(new int[]{y, x});
                    dist[y][x] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; ++i) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                if (ny < 0 || ny == n || nx < 0 || nx == n || dist[ny][nx] != -1) {
                    continue;
                }
                dist[ny][nx] = dist[pos[0]][pos[1]] + 1;
                q.add(new int[]{ny, nx});
            }
        }

        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            if (top[1] == n - 1 && top[2] == n - 1) {
                ans = top[0];
                break;
            }

            for (int i = 0; i < 4; ++i) {
                int ny = top[1] + dy[i];
                int nx = top[2] + dx[i];
                if (ny < 0 || ny == n || nx < 0 || nx == n || dist[ny][nx] == -1) {
                    continue;
                }
                pq.add(new int[]{Math.min(top[0], dist[ny][nx]), ny, nx});
                dist[ny][nx] = -1;
            }
        }
        return ans;
    }
}