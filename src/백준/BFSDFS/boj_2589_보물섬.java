package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2589_보물섬 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int row, col;
    private static boolean[][] map;
    private static int[][] visited;
    private static List<Integer> dirx = List.of(-1, 1, 0, 0);
    private static List<Integer> diry = List.of(0, 0, -1, 1);

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new boolean[row][col]; //true-> land, false -> water

        saveInput();
        System.out.println(scanMap());

    }

    private static int scanMap() {
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //땅인 경우만 탐색
                if (map[i][j]) max = Math.max(max, bfs(i, j));
            }
        }
        return max;
    }

    private static int bfs(int x, int y) {
        visited = new int[row][col];

        int max = 0;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();
            max = Math.max(max, visited[now.x][now.y]);

            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dirx.get(i);
                int mvy = now.y + diry.get(i);

                //벗어남
                if (mvx >= map.length || mvx < 0 || mvy < 0 || mvy >= map[0].length) continue;

                //땅이고, 방문 안된 노드이면
                if (map[mvx][mvy] && visited[mvx][mvy] == 0) {
                    visited[mvx][mvy] = visited[now.x][now.y] + 1;
                    q.add(new Point(mvx, mvy));
                }
            }
        }
        return max - 1;
    }

    private static void saveInput() throws IOException {
        for (int i = 0; i < row; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                char input = temp[j];
                boolean saveInput = false;
                if (input == 'L') saveInput = true; //땅인 경우만 true 리턴
                map[i][j] = saveInput;
            }
        }
    }

}
