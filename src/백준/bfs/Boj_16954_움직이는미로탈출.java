package 백준.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Boj_16954_움직이는미로탈출 {
    private static final int[] dirx = new int[]{-1, 1, 0, 0, 0, -1, 1, 1, -1};
    private static final int[] diry = new int[]{0, 0, -1, 1, 0, -1, 1, -1, 1};
    private static char[][] map = new char[8][8];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][][] visited = new boolean[9][8][8];
        Queue<Point> me = new ArrayDeque<>();

        for (int i = 0; i < 8; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    visited[0][i][j] = true;
                }
            }
        }

        boolean flag = false;
        int time = 0;
        me.add(new Point(7, 0));

        while (!me.isEmpty() && !flag) {
            //벽이 이미 다 없어 졌다면 끝
            if (isNoWall()) {
                flag = true;
                break;
            }

            time++;
            //나 먼저 이동
            int size = me.size();
            for (int i = 0; i < size; i++) {
                Point poll = me.poll();
                if (map[poll.x][poll.y] == '#') continue;//이동했던 칸이 벽이여서 움직이지 못함

                for (int j = 0; j < dirx.length; j++) {
                    int mvX = poll.x + dirx[j];
                    int mvY = poll.y + diry[j];

                    if (mvX < 0 || 8 <= mvX || mvY < 0 || 8 <= mvY) {
                        continue;
                    }
                    if (visited[time][mvX][mvY] || map[mvX][mvY] == '#') {
                        continue;
                    }

                    if (mvX == 0 && mvY == 7) {
                        flag = true;
                        break;
                    }

                    visited[time][mvX][mvY] = true;
                    me.add(new Point(mvX, mvY));

                }
            }

            //벽 이동
            Arrays.fill(map[7], '.');
            for (int i = 6; 0 <= i; i--) {
                for (int j = 0; j < 8; j++) {
                    if (map[i][j] == '#') {
                        map[i][j] = '.';
                        map[i + 1][j] = '#';
                    }
                }
            }

        }

        System.out.println(flag ? 1 : 0);


    }

    private static boolean isNoWall() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == '#') {
                    return false;
                }
            }
        }
        return true;
    }
}
