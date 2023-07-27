package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_19238_스타트택시 {
    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int size;
    private static char[][] map;
    private static final List<Point[]> user = new ArrayList<>();
    private static final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        //n,m 초기연로
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int oil = Integer.parseInt(st.nextToken());

        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        //운전 시작하는 줄
        st = new StringTokenizer(br.readLine());
        Point driver = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        //m개의 줄에 승객
        //출발 도착
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            user.add(new Point[]{new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1),
                    new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1)});
        }

        while (!user.isEmpty()) {
            int[] minUser = selectPassenger(driver); //선택한 승객, 움직일 거리

            // 승객의 위치까지 이동
            if (minUser[1] < 0 || oil < minUser[1]) {
                System.out.println(-1);
                return;
            }
            oil -= minUser[1];

            // 승객과 운항
            int usedOil = runTaxi(minUser);
            if (usedOil < 0 || oil < usedOil) {
                System.out.println(-1);
                return;
            }
            oil -= usedOil;

            //기름 두배
            oil += usedOil * 2;
            driver = user.get(minUser[0])[1];//운전사 이동

            //유저 지우기
            user.remove(minUser[0]);
        }

        System.out.println(oil);

    }

    private static int runTaxi(int[] minUser) {//택시 이동
        Point start = user.get(minUser[0])[0];
        Point end = user.get(minUser[0])[1];
        boolean[][] visited = new boolean[size][size];
        visited[start.x][start.y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int usingOil = -1;

        while (!q.isEmpty()) {
            usingOil++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Point poll = q.poll();

                if (poll.x == end.x && poll.y == end.y) return usingOil;
                for (int[] dir : dirs) {
                    int mvx = dir[0] + poll.x;
                    int mvy = dir[1] + poll.y;
                    if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy || visited[mvx][mvy] || map[mvx][mvy] == '1') {
                        continue;
                    }

                    q.add(new Point(mvx, mvy));
                    visited[mvx][mvy] = true;
                }
            }
        }

        return -1;
    }

    private static int[] selectPassenger(Point nowDriver) {//승객을 고른다
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int[][] distances = getDistancesMap(new Point(nowDriver.x, nowDriver.y));

        for (int i = 0; i < user.size(); i++) {
            Point startPoint = user.get(i)[0];
            int nowUsingOil = distances[startPoint.x][startPoint.y];

            if (nowUsingOil < min) {
                minIdx = i;
                min = nowUsingOil;
            } else if (nowUsingOil == min) {
                if (user.get(minIdx)[0].x > startPoint.x) {
                    minIdx = i;
                } else if (user.get(minIdx)[0].x == startPoint.x) {
                    if (user.get(minIdx)[0].y > startPoint.y) {
                        minIdx = i;
                    }
                }
            }
        }

        return new int[]{minIdx, min - 1};
    }

    private static int[][] getDistancesMap(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        int[][] visited = new int[size][size];
        visited[start.x][start.y] = 1;
        int depth = 1;

        while (!q.isEmpty()) {
            depth++;
            int size1 = q.size();
            for (int i = 0; i < size1; i++) {
                Point poll = q.poll();
                for (int[] dir : dirs) {
                    int mvx = dir[0] + poll.x;
                    int mvy = dir[1] + poll.y;
                    if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy || visited[mvx][mvy] != 0 || map[mvx][mvy] == '1') {
                        continue;
                    }

                    q.add(new Point(mvx, mvy));
                    visited[mvx][mvy] = depth;
                }
            }
        }

        return visited;
    }
}
