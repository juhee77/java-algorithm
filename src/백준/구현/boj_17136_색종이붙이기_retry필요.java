package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17136_색종이붙이기_retry필요 {
    public static final int MAP_SIZE = 10;
    private static final int[][] dirs = {{1, 1}, {0, 1}, {1, 0}};
    private static final int[] used = {0, 0, 0, 0, 0, 0};
    private static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //input
        int[][] map = new int[MAP_SIZE][MAP_SIZE];
        int initX = -1, initY = 0;
        for (int i = 0; i < MAP_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < MAP_SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 && initX == -1) {
                    initX = i;
                    initY = j;
                }
            }
        }

        //solution
        if (initX == -1) System.out.println(0);
        else {
            bfs(initX, initY, map);
            if (cnt == Integer.MAX_VALUE) {
                System.out.println(-1); //5장을 넘게 사용해야하는경우}
            } else {
                System.out.println(cnt);
            }
        }
    }

    private static void bfs(int x, int y, int[][] map) {
        int range = 1;
        boolean[][] visited = new boolean[MAP_SIZE][MAP_SIZE];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            boolean nextFalse = false;

            for (int i = 0; i < size; i++) { //다음에 가능한 칸을 확인한다.
                int[] poll = q.poll();
                map[poll[0]][poll[1]] = 0;

                for (int[] dir : dirs) {
                    int movedx = poll[0] + dir[0];
                    int movedy = poll[1] + dir[1];

                    if (movedx < 0 || movedy < 0 || MAP_SIZE <= movedx || MAP_SIZE <= movedy) {
                        //정사각형 종이로 채워지지 않는다., 다음칸이 채우지 않아도 되는칸이다.
                        nextFalse = true;
                        break;
                    }
                    if (visited[movedx][movedy]) continue;// 이미 체크 했다.
                    if (map[movedx][movedy] == 0) {
                        nextFalse = true;
                        break;
                    }

                    visited[movedx][movedy] = true;
                    q.add(new int[]{movedx, movedy});
                }
            }

            used[range]++;
            if (used[range] <= 5) {

                boolean nextFind = false;
                LOOP:
                for (int i = x; i < MAP_SIZE; i++) {
                    for (int j = 0; j < MAP_SIZE; j++) {
                        if (map[i][j] == 1) {
                            int[][] map2 = new int[MAP_SIZE][MAP_SIZE];
                            for (int p = 0; p < MAP_SIZE; p++) {
                                map2[p] = map[p].clone();
                            }

                            bfs(i, j, map2);
                            nextFind = true;
                            break LOOP;
                        }
                    }
                }
                if (!nextFind) {
                    //끝까지 탐색했다
                    int min = Arrays.stream(used).sum();
                    cnt = Math.min(min, cnt);
                }
            }
            used[range]--;
            range++;

            if (nextFalse || range == 6) {
                break;
            }
        }
    }
}