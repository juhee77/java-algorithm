package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_4963_섬의개수 {
    private static int w, h;
    private static int[][] map;
    private static boolean[][] visited;
    private static final Queue<int[]> queue = new LinkedList<>();
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(findLands()).append("\n");

        }
        System.out.println(sb);
    }

    public static int findLands() {
        int cnt = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    coloredLands(new int[]{i, j});
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void coloredLands(int[] point) {
        visited[point[0]][point[1]] = true;
        queue.add(point);

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int mvX = p[0] + dir[0];
                int mvY = p[1] + dir[1];
                if (mvY < 0 || mvX < 0 || h <= mvX || w <= mvY || visited[mvX][mvY] || map[mvX][mvY] == 0) continue;
                visited[mvX][mvY] = true;
                queue.add(new int[]{mvX, mvY});
            }
        }
    }

}
