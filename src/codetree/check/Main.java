package codetree.check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] dirs = {{0, 1}, {1, 0}};
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[r][r];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < r; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        int cnt = 0;

        // 초기 큐 삽입 (방문 체크)
        if (r > 1 && arr[0][1] == 0) {
            queue.add(new int[]{0, 1, 0, 0}); // 오른쪽 이동
        }
        if (r > 1 && arr[1][0] == 0) {
            queue.add(new int[]{1, 0, 1, 0}); // 아래쪽 이동
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dir = cur[2], dircnt = cur[3];

            // 목적지 도착
            if (x == r - 1 && y == r - 1) {
                cnt++;
                continue;
            }

            for (int i = 0; i < 2; i++) {
                int mvX = x + dirs[i][0];
                int mvY = y + dirs[i][1];

                if (mvX < 0 || mvY < 0 || mvX >= r || mvY >= r || arr[mvX][mvY] != 0) continue;

                int newDirCnt = (i == dir) ? dircnt : dircnt + 1;
                if (newDirCnt > k) continue;

                queue.add(new int[]{mvX, mvY, i, newDirCnt});
            }
        }

        System.out.println(cnt);
    }
}
