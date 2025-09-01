package 백준.BFSDFS.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14940_쉬운최단거리 {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] map = new int[row][col];
        int[] goal = new int[2];

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        int[][] ans = new int[row][col];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{goal[0], goal[1]});
        ans[goal[0]][goal[1]] = 1;

        int now = 2;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int j = 0; j < sz; j++) {
                int[] poll = q.poll();

                for (int[] dir : dirs) {
                    int mvX = poll[0] + dir[0];
                    int mvY = poll[1] + dir[1];
                    if (0 <= mvX && 0 <= mvY && mvX < row && mvY < col && ans[mvX][mvY] == 0 && map[mvX][mvY] == 1) {
                        ans[mvX][mvY] = now;
                        q.add(new int[]{mvX, mvY});
                    }
                }
            }
            now++;
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (map[i][j] == 0) {
                    sb.append(0).append(" ");
                } else {
                    sb.append((ans[i][j] - 1) + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
