package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600_말이되고픈원숭이 {
    private static int w, h;
    private static int[][] map;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int[][] horseDirs = {{-1, -2}, {-2, -1}, {1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}};
    private static boolean[][][] visited;
    private static final Queue<Monk> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w][k+1]; //뛰어 넘어서 도착한 경우와 인접해서 넘어온 경우
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(findMin(k));
    }

    private static int findMin(int k) {
        if (map[0][0] == 1 || map[h - 1][w - 1] == 1) return -1;
        if (w == 1 && h == 1) return 0;

        //0 : x, 1:y, 2:k
        q.add(new Monk(0, 0, k));
        Arrays.fill(visited[0][0],true);
        int nowMoveCnt = 0;
        while (!q.isEmpty()) {
            nowMoveCnt++; //움직인 칸을 확인할 것 이므로
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Monk now = q.poll();
                if (now.k > 0) {
                    if (checkFinAndAddNext(now.k - 1, horseDirs, now)) {
                        return nowMoveCnt;
                    }
                }

                if (checkFinAndAddNext(now.k, dirs, now)) {
                    return nowMoveCnt;
                }
            }
        }
        return -1;
    }

    private static boolean checkFinAndAddNext(int k, int[][] dirs, Monk now) {
        for (int[] dir : dirs) {
            int movedX = now.x + dir[0];
            int movedY = now.y + dir[1];
            if (movedX < 0 || movedY < 0 || h <= movedX || w <= movedY || map[movedX][movedY] == 1 || visited[movedX][movedY][k])
                continue;
            if (movedX == h - 1 && movedY == w - 1) {
                return true;//마지막에 다다랐으면
            }

            visited[movedX][movedY][k] = true;
            q.add(new Monk(movedX, movedY, k));
        }
        return false;
    }

    private static class Monk {
        int x, y, k;

        public Monk(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
}
