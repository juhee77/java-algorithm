package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1926_그림 {
    private static char[][] map;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        int maxSize = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == '1') {
                    maxSize = Math.max(coloredMap(i, j), maxSize);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append("\n").append(maxSize);
        System.out.println(sb);

    }

    private static int coloredMap(int i, int j) {
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        int size = 1;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int[] ints : dir) {
                int mvx = poll[0] + ints[0];
                int mvy = poll[1] + ints[1];
                if (mvx < 0 || mvy < 0 || n <= mvx || m <= mvy || visited[mvx][mvy] || map[mvx][mvy] == '0') continue;
                q.add(new int[]{mvx, mvy});
                visited[mvx][mvy] = true;
                size++;
            }
        }
        return size;
    }
}
