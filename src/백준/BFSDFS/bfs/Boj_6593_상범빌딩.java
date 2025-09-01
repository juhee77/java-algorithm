package 백준.BFSDFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_6593_상범빌딩 {
    private static char[][][] map;
    private static boolean[][][] visited;
    private static int stair, row, col;
    private static final int[][] dirs = new int[][]{{0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}, {1, 0, 0}, {-1, 0, 0}};
    private static final Queue<Point> sangbom = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            stair = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            if (stair == 0 && row == 0 && col == 0) {
                break;
            }

            sangbom.clear();
            map = new char[stair][row][col];
            visited = new boolean[stair][row][col];


            for (int i = 0; i < stair; i++) {
                for (int j = 0; j < row; j++) {
                    map[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < col; k++) {
                        if (map[i][j][k] == 'S') {
                            sangbom.add(new Point(i, j, k));
                            visited[i][j][k] = true;
                        }
                    }
                }
                br.readLine();
            }

            int ans = findRoad();
            if (ans == -1) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in ").append(ans).append(" minute(s).").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int findRoad() {
        int time = 0;
        while (!sangbom.isEmpty()) {
            int size = sangbom.size();
            time++;

            for (int i = 0; i < size; i++) {
                Point now = sangbom.poll();

                for (int[] dir : dirs) {
                    int mvZ = now.stair + dir[0];
                    int mvX = now.x + dir[1];
                    int mvY = now.y + dir[2];

                    if (mvZ < 0 || mvX < 0 || mvY < 0 || stair <= mvZ || row <= mvX || col <= mvY
                            || visited[mvZ][mvX][mvY]) {
                        continue;
                    }

                    if (map[mvZ][mvX][mvY] == '#') { //벽
                        continue;
                    }

                    if (map[mvZ][mvX][mvY] == 'E') {
                        return time;
                    }
                    visited[mvZ][mvX][mvY] = true;
                    sangbom.add(new Point(mvZ, mvX, mvY));
                }
            }
        }
        return -1;
    }

    private static class Point {
        int stair, x, y;

        public Point(int stair, int x, int y) {
            this.stair = stair;
            this.x = x;
            this.y = y;
        }
    }
}
