package 백준.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj_2665_미로만들기 {
    private static int[][] minRoom;
    private static char[][] map;
    private static int sz;
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static class Point {
        int x, y, minRoom;

        public Point(int x, int y, int minRoom) {
            this.x = x;
            this.y = y;
            this.minRoom = minRoom;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sz = Integer.parseInt(br.readLine());
        map = new char[sz][sz];
        for (int i = 0; i < sz; i++)
            map[i] = br.readLine().toCharArray();


        minRoom = new int[sz][sz];
        find(0, 0);

        System.out.println(minRoom[sz - 1][sz - 1] - 1);
    }

    public static void find(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y, 1));
        minRoom[x][y] = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Point poll = queue.poll();

                for (int[] dir : dirs) {
                    int mvX = dir[0] + poll.x;
                    int mvY = dir[1] + poll.y;

                    if (mvY < 0 || mvX < 0 || sz <= mvX || sz <= mvY) {
                        continue;
                    }

                    if (map[mvX][mvY] == '0') {
                        //막힌 방
                        if (minRoom[mvX][mvY] == 0 || minRoom[mvX][mvY] > poll.minRoom + 1) {
                            minRoom[mvX][mvY] = poll.minRoom + 1;
                            queue.add(new Point(mvX, mvY, poll.minRoom + 1));
                        }

                    } else {
                        //휜방
                        if (minRoom[mvX][mvY] == 0 || minRoom[mvX][mvY] > poll.minRoom) {
                            minRoom[mvX][mvY] = poll.minRoom;
                            queue.add(new Point(mvX, mvY, poll.minRoom));
                        }
                    }
                }

            }
//            for (int[] ints : minRoom) System.out.println(Arrays.toString(ints));
//            System.out.println("\n\n");
        }
    }
}
