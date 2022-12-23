package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2583_영역구하기 {
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    private static boolean[][] map;
    private static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        map = new boolean[row][col];

        while (cnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int endX = row - Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int startX = row - Integer.parseInt(st.nextToken());
            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    map[i][j] = true;
                }
            }
        }

        int bound = 0;
        List<Integer> boundSize = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!map[i][j]) {
                    boundSize.add(bfs(i, j));
                    bound++;
                }
            }
        }
        sb.append(bound).append("\n");
        Collections.sort(boundSize);
        for (int e : boundSize) {
            sb.append(e).append(" ");
        }
        System.out.println(sb);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        map[x][y] = true;
        int size = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            size++;
            for (int i = 0; i < dirX.length; i++) {
                int mvx = now[0] + dirX[i];
                int mvy = now[1] + dirY[i];
                if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) continue;

                if (!map[mvx][mvy]) {
                    q.add(new int[]{mvx, mvy});
                    map[mvx][mvy] = true;
                }
            }
        }
        return size;
    }
}
