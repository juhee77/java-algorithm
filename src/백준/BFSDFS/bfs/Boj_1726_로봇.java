package 백준.BFSDFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1726_로봇 {
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static robot start, end;
    private static int row, col;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken()) - 1;
        int startCol = Integer.parseInt(st.nextToken()) - 1;
        int startDir = convertDir(Integer.parseInt(st.nextToken()));
        start = new robot(startRow, startCol, startDir);

        st = new StringTokenizer(br.readLine());
        int endRow = Integer.parseInt(st.nextToken()) - 1;
        int endCol = Integer.parseInt(st.nextToken()) - 1;
        int endDir = convertDir(Integer.parseInt(st.nextToken()));
        end = new robot(endRow, endCol, endDir);

        System.out.println(getMin());


    }

    private static int getMin() {
        Queue<robot> queue = new LinkedList<>();
        queue.add(start);
        boolean[][][] visited = new boolean[row][col][4];
        visited[start.row][start.col][start.dir] = true;
        int cmd = 0;

        while (!queue.isEmpty()) {
            int pointSize = queue.size();
            for (int i = 0; i < pointSize; i++) {
                robot poll = queue.poll();

                if (poll.row == end.row && poll.col == end.col && poll.dir == end.dir) {
                    return cmd;
                }

                //그냥 가는 경우(go)
                for (int len = 1; len <= 3; len++) {
                    int mvX = poll.row + dirs[poll.dir][0] * len;
                    int mvY = poll.col + dirs[poll.dir][1] * len;

                    if (0 <= mvX && 0 <= mvY && mvX < row && mvY < col) {
                        //만약 가는 길에 1이 있다면 멈춤
                        if (map[mvX][mvY] == 1) break;

                        if (!visited[mvX][mvY][poll.dir]) {
                            queue.add(new robot(mvX, mvY, poll.dir));
                            visited[mvX][mvY][poll.dir] = true;
                        }
                    }
                }

                //방향 바꾸는 경우 오른쪽
                int nextDir = (poll.dir + 1) % 4;
                if (!visited[poll.row][poll.col][nextDir]) {
                    queue.add(new robot(poll.row, poll.col, nextDir));
                    visited[poll.row][poll.col][nextDir] = true;
                }

                //방향 바꾸는 경우 왼쪽
                nextDir = (poll.dir + 3) % 4;
                if (!visited[poll.row][poll.col][nextDir]) {
                    queue.add(new robot(poll.row, poll.col, nextDir));
                    visited[poll.row][poll.col][nextDir] = true;
                }
            }
            cmd++;
        }
        return -1;
    }

    private static int convertDir(int dir) {
        switch (dir) {
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            case 4:
                return 3;
        }
        throw new RuntimeException("이상");
    }

    private static class robot {
        int row, col, dir;

        public robot(int row, int col, int dir) {
            this.row = row;
            this.col = col;
            this.dir = dir;
        }
    }
}
