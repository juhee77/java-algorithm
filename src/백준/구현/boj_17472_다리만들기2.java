package 백준.구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17472_다리만들기2 {
    /*
     * 다리는 바다에만 건설할 수 있고, 다리의 길이는 다리가 격자에서 차지하는 칸의 수이다. 다리를 연결해서 모든 섬을 연결하려고 한다. 한
     * 다리의 방향이 중간에서 바뀌면 안되고 다리의길이는 2이상이어야 한다. 다리를 연결하다 중간에 있는 섬은 연결된것이 아니다. 다리의 길이는
     * 겹치는 구간도 포함한다. 모든 섬을 연결하는 다리의 최솟값을 구하여라 다리는 가로로 여녁ㄹ되어야 한다.
     */

    private static int N, M;
    private static int[][] map;
    private static final ArrayList<Point> ilands = new ArrayList<>();
    private static final ArrayList<ArrayList<Point>> ilandsEdges = new ArrayList<>();
    private static final int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    private static int[][] minDistanceIlands;
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
        int nowIlandCnt = 10;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    // 하나의 섬을 발견했다.
                    ilands.add(new Point(i, j));
                    ilandsEdges.add(new ArrayList<>());

                    // 연결됨 섬을 색칠한다.
                    findIland(i, j, nowIlandCnt++);
                }
            }
        }

        // 각 섬에 대해서 주변으로 바다가 있는 경우 모두 나아갔을때 섬이랑 만나는 경로를 찾는다.
        minDistanceIlands = new int[ilands.size()][ilands.size()];
        for (int i = 0; i < ilands.size(); i++) {
            Arrays.fill(minDistanceIlands[i], Integer.MAX_VALUE);
            findIlandAndDistance(i);
        }

//		for (int i = 0; i < ilands.size(); i++) {
//			System.out.println(Arrays.toString(minDistanceIlands[i]));
//		}
        // 각 섬에 대해서 모든 섬으로 향하는 최단 값 크루스칼
        System.out.println(findMin());
    }

    private static int findMin() {
        LinkedList<Line> pq = new LinkedList<>();
        parents = new int[ilands.size()];
        for (int i = 0; i < ilands.size(); i++)
            parents[i] = i;

        for (int i = 0; i < ilands.size(); i++) {
            for (int j = 0; j < ilands.size(); j++) {
                if (minDistanceIlands[i][j] == Integer.MAX_VALUE)
                    continue;
                pq.add(new Line(i, j, minDistanceIlands[i][j]));
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

        for (int i = 0; i < ilands.size(); i++) {
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

    private static void findIlandAndDistance(int idx) {
        for (Point now : ilandsEdges.get(idx)) {
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
                        if (mvx < 0 || mvy < 0 || N <= mvx || M <= mvy || map[mvx][mvy] == idx + 10) { // 범위를 벗어 나거나 자신의
                            break;
                        }

                        if (map[mvx][mvy] >= 10) {
                            findLand = map[mvx][mvy] - 10;
                            break;
                        }
                    }
                    if (findLand != -1 && minDistance >= 2) {
                        minDistanceIlands[idx][findLand] = Math.min(minDistanceIlands[idx][findLand], minDistance);
                    }
                }
            }
        }
    }

    private static void findIland(int x, int y, int color) {
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
            if (seaF)
                ilandsEdges.get(color - 10).add(out);
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
