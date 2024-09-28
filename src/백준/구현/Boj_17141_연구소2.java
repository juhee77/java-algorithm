package 백준.구현;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17141_연구소2 {
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static final char WALL = '1';
    public static final char EMPTY = '0';
    public static final char VIRUS = '2';
    public static final char VIRUSED = '3';
    private static int row, ableVirusCnt;
    private static char[][] arr;
    private static ArrayList<Point> ablesVirus = new ArrayList<Point>();
    private static int min = Integer.MAX_VALUE;
    private static int[] virus;
    private static boolean[] visitedVirus;
    private static char[][] copiedArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        ableVirusCnt = Integer.parseInt(st.nextToken());
        arr = new char[row][row];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                arr[i][j] = st.nextToken().charAt(0);
                if (arr[i][j] == VIRUS) {
                    ablesVirus.add(new Point(i, j));
                }
            }
        }

        virus = new int[ableVirusCnt];
        visitedVirus = new boolean[ablesVirus.size()];
        find(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    private static void find(int nowLevel, int start) {
        if (nowLevel == ableVirusCnt) {
            min = Math.min(findMinTime(), min);
            return;
        }

        for (int i = start; i < ablesVirus.size(); i++) {
            if (!visitedVirus[i]) {
                virus[nowLevel] = i;
                visitedVirus[i] = true;
                find(nowLevel + 1, i + 1);
                visitedVirus[i] = false;
            }
        }

    }

    private static int findMinTime() {
        copiedArr = new char[row][row];
        for (int i = 0; i < row; i++) {
            copiedArr[i] = arr[i].clone();
        }

        Queue<Point> q = new ArrayDeque<>();
        for (int i : virus) {
            Point now = ablesVirus.get(i);
            q.add(now);
            copiedArr[now.x][now.y] = VIRUSED;
        }

        int time = -1;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            while (size-- > 0) {
                Point poll = q.poll();
                for (int[] dir : dirs) {
                    int mvX = poll.x + dir[0];
                    int mvY = poll.y + dir[1];

                    if (mvX < 0 || row <= mvX || mvY < 0 || row <= mvY
                            || copiedArr[mvX][mvY] == VIRUSED || copiedArr[mvX][mvY] == WALL) {
                        continue;
                    }

                    q.add(new Point(mvX, mvY));
                    copiedArr[mvX][mvY] = VIRUSED;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (copiedArr[i][j] == EMPTY || copiedArr[i][j] == VIRUS) {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return time;
    }
}
