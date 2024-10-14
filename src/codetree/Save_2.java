package codetree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Save_2 {
    private static int size;
    private static char[][] arr;
    private static boolean[][] visited;
    private static final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        size = Integer.parseInt(br.readLine());
        arr = new char[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                arr[i][j] = st.nextToken().charAt(0);
            }
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            if (visited[x][y]) {
                System.out.println(0);
                return;
            } else {
                Queue<int[]> q = new ArrayDeque<>();
                q.add(new int[]{x, y});
                visited[x][y] = true;
                while (!q.isEmpty()) {
                    int[] poll = q.poll();
                    for (int[] dir : dirs) {
                        int mvX = poll[0] + dir[0];
                        int mvY = poll[1] + dir[1];
                        if (mvX < 0 || mvY < 0 || size <= mvX || size <= mvY || visited[mvX][mvY] || arr[mvX][mvY] == '0')
                            continue;
                        q.add(new int[]{mvX, mvY});
                        visited[mvX][mvY] = true;
                    }
                }
            }
            System.out.println(1);

        }
    }
}