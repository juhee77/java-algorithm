package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17472_다리만들기2 {
    private static final ArrayList<ArrayList<Point>> landsSeaEdges = new ArrayList<>();
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static final int MAX = Integer.MAX_VALUE;

    private static int N, M;
    private static int landCnt = 0;
    private static int[][] map;
    private static int[][] minBridges;
    private static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬을 찾아서 주변에 바다가 있는경우 해당 바다의 위치로 나가는 방향으로 가능한 섬이 있는지 확인한다.
        int nowLandColor = 10;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    // 하나의 섬을 발견했다.
                    landsSeaEdges.add(new ArrayList<>());
                    landCnt++;

                    // 연결됨 섬을 색칠한다.
                    findLand(i, j, nowLandColor++);
                }
            }
        }

        // 각 섬에 대해서 주변으로 바다가 있는 경우 모두 나아갔을때 섬이랑 만나는 경로를 찾는다.
        minBridges = new int[landCnt][landCnt];
        for (int i = 0; i < landCnt; i++) {
            Arrays.fill(minBridges[i], MAX);
            findBridgeDistance(i);
        }

        // 각 섬에 대해서 모든 섬으로 향하는 최단 값 크루스칼
        System.out.println(findMinMst());
    }

    //최단 경로를 탐색한다.
    private static int findMinMst() {
        LinkedList<Line> pq = new LinkedList<>();
        parents = new int[landCnt];
        for (int i = 0; i < landCnt; i++)
            parents[i] = i;

        //다리를 둘 수 있는 경우만 추가한다.
        for (int i = 0; i < landCnt; i++) {
            for (int j = 0; j < landCnt; j++) {
                if (minBridges[i][j] == MAX)
                    continue;
                pq.add(new Line(i, j, minBridges[i][j]));
            }
        }
        Collections.sort(pq);

        int min = 0;
        while (!pq.isEmpty()) {
            Line l = pq.poll();
            if (findParent(l.x) == findParent(l.y))
                continue;
            min += l.cost;
            unionParents(l.x, l.y);
        }

        //모든 섬을 연결하지 못하는 경우
        for (int i = 0; i < landCnt; i++) {
            if (findParent(parents[i]) != 0)
                return -1;
        }
        return min;
    }

    public static int findParent(int x) {
        if (parents[x] == x)
            return x;
        return parents[x] = findParent(parents[x]);
    }

    public static void unionParents(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }
    }

    private static void findBridgeDistance(int idx) {
        for (Point now : landsSeaEdges.get(idx)) {
            // 각 섬의 위치에서 바다인 방면을 향해서 나아갔을때 섬이 있는경우 mindistance를 변경한다.

            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dirs[i][0];
                int mvy = now.y + dirs[i][1];

                if (mvx < 0 || mvy < 0 || N <= mvx || M <= mvy)
                    continue;
                if (map[mvx][mvy] == 0) {
                    // 해당 방면으로 나아갔을 경우 섬이 있는지 확인한다.

                    int minDistance = 0;
                    int findLand = -1;
                    while (true) {
                        minDistance++;
                        mvx += dirs[i][0];
                        mvy += dirs[i][1];
                        if (mvx < 0 || mvy < 0 || N <= mvx || M <= mvy || map[mvx][mvy] == idx + 10) { // 범위를 벗어 나거나 자신의 섬인경우
                            break;
                        }

                        if (map[mvx][mvy] >= 10) {
                            findLand = map[mvx][mvy] - 10;
                            break;
                        }
                    }
                    if (findLand != -1 && minDistance >= 2) {
                        minBridges[idx][findLand] = Math.min(minBridges[idx][findLand], minDistance);
                    }
                }
            }
        }
    }

    private static void findLand(int x, int y, int color) {
        map[x][y] = color;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point out = q.poll();
            boolean seaF = false;

            for (int[] dir : dirs) {
                int mvx = out.x + dir[0];
                int mvy = out.y + dir[1];

                if (mvx < 0 || mvy < 0 || N <= mvx || M <= mvy)
                    continue;
                if (map[mvx][mvy] >= 10)
                    continue;
                if (map[mvx][mvy] == 0) {
                    seaF = true;
                    continue;
                }
                map[mvx][mvy] = color;
                q.add(new Point(mvx, mvy));
            }
            if (seaF) //4방위중 바다가 있는 경우메나 추가한다.
                landsSeaEdges.get(color - 10).add(out);
        }
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Line implements Comparable<Line> {
        int x, y, cost;

        public Line(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Line o) {
            return this.cost - o.cost;
        }
    }
}
