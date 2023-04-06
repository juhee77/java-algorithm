package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 코드트리_빵 {
    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Human extends Point {
        int idx;

        Human(int x, int y, int idx) {
            super(x, y);
            this.idx = idx;
        }
    }

    private static final int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private static int n, m;
    private static int[][] map;
    private static final ArrayList<Point> store = new ArrayList<>(); // 각 사람이 가고자 하는 편의점 위치
    private static boolean[] alreadyFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean[][][] visited = new boolean[m][n][n]; // 0번은 토탈, 1-2-3- 사람
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    map[i][j] = 1; // 게스트 하우스 위치 있음
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            store.add(new Point(x, y));
            map[x][y] = 2;// 편의점 위치 //못가는 칸은 -1
        }

        alreadyFind = new boolean[m];
        int nowUser = 1;
        int time = 0;

        Queue<Human> humans = new LinkedList<>();
        while (true) {
            time++;
            // 1 && 2
            int sz = humans.size();
            for (int i = 0; i < sz; i++) {
                // 4방향으로 갈 수 있는 칸으로 모두 진행한다.
                Human now = humans.poll();
                if (alreadyFind[now.idx])
                    continue;// 이미 편의점을 찾아 들어갔다.

                for (int[] dir : dirs) {
                    int movedX = now.x + dir[0];
                    int movedY = now.y + dir[1];

                    if (movedX < 0 || movedY < 0 || n <= movedX || n <= movedY)
                        continue;
                    if (visited[now.idx][movedX][movedY] || map[movedX][movedY] == -1)
                        continue; // 이미 방문했거나. 갈 수 없는 칸이면
                    if (map[movedX][movedY] == 2 && movedX == store.get(now.idx).x && movedY == store.get(now.idx).y) {
                        // 자신이  가고자  하는 편의점을 발견했다.
                        alreadyFind[now.idx] = true;
                        map[movedX][movedY] = -1;
                    }
                    visited[now.idx][movedX][movedY] = true;
                    humans.add(new Human(movedX, movedY, now.idx));

                }
            }

            if (checkAllInStore()) break;

            // 3
            if (time >= nowUser && nowUser <= m) {
                // 주변의 가능한 게스트 하우스중 최단거리의 게스트 하우스를 찾는다
                Point nowUserP = store.get(nowUser - 1);
                Point guestHouse = findGuestHouse(nowUserP);
                map[guestHouse.x][guestHouse.y] = -1; // 이제부터 못 다닌다.
                humans.add(new Human(guestHouse.x, guestHouse.y, nowUser - 1));
                nowUser++;
            }

        }

        System.out.println(time);
    }

    private static boolean checkAllInStore() {
        boolean allInStore = true;
        for (int i = 0; i < m; i++) {
            if (!alreadyFind[i]) {
                allInStore = false;
                break;
            }
        }
        return allInStore;
    }

    private static Point findGuestHouse(Point nowUserP) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] tmpVisited = new boolean[n][n];
        tmpVisited[nowUserP.x][nowUserP.y] = true;
        q.add(nowUserP);

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int[] dir : dirs) {
                int movedX = now.x + dir[0];
                int movedY = now.y + dir[1];

                if (movedX < 0 || movedY < 0 || n <= movedX || n <= movedY)
                    continue;
                if (tmpVisited[movedX][movedY] || map[movedX][movedY] == -1)
                    continue; // 이미 방문했거나. 갈 수 없는 칸이면
                if (map[movedX][movedY] == 1) { // 가장 가까운 곳 발견했다.
                    return new Point(movedX, movedY);
                }
                tmpVisited[movedX][movedY] = true;
                q.add(new Point(movedX, movedY));

            }

        }

        return null;
    }

}