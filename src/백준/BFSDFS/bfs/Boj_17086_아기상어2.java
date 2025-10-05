package 백준.BFSDFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_17086_아기상어2 {
    private static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}, {-1, -1},
            {-1, 0}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] map = new int[row][col];
        int[][] distance = new int[row][col];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(distance[i], -1);
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int currentX = now[0];
            int currentY = now[1];

            for (int[] dir : dirs) {
                int mvX = currentX + dir[0];
                int mvY = currentY + dir[1];

                if (mvX < 0 || mvY < 0 || row <= mvX || col <= mvY || distance[mvX][mvY] != -1) {
                    continue;
                }

                distance[mvX][mvY] = distance[currentX][currentY] + 1;
                q.add(new int[]{mvX, mvY});
            }
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(max, distance[i][j]);
            }
        }
        System.out.println(max);
    }
}