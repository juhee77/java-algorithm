package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1303_전쟁전투 {
    private static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        char[][] map = new char[row][col];
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int white = 0, blue = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    int cnt = 1;
                    visited[i][j] = true;
                    Queue<Point> queue = new ArrayDeque<>();
                    queue.add(new Point(i, j));
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            Point now = queue.poll();
                            for (int[] dir : dirs) {
                                int mvX = now.x + dir[0];
                                int mvY = now.y + dir[1];
                                if (mvY < 0 || mvX < 0 || row <= mvX || col <= mvY || map[mvX][mvY] != map[i][j]) {
                                    continue;
                                }
                                if (!visited[mvX][mvY]) {
                                    visited[mvX][mvY] = true;
                                    cnt++;
                                    queue.add(new Point(mvX, mvY));
                                }
                            }
                        }
                    }
                    cnt *= cnt;
                    if (map[i][j] == 'W') white += cnt;
                    else blue += cnt;
                }
            }
        }
        System.out.println(white + " " + blue);
    }
}
