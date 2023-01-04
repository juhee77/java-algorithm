package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_4485_dijkstra {
    private static class Node implements Comparable<Node> {
        int x, y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return distance - other.distance;
        }
    }

    private static int size;
    private static int[][] map;
    private static final int INF = (int) 1e9;
    private static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int proCount = 1;

        while ((size = Integer.parseInt(br.readLine())) != 0) {
            map = new int[size][size];

            for (int i = 0; i < size; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(proCount++).append(": ").append(dijkstra(0, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int dijkstra(int startX, int startY) {
        int[][] distance = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(distance[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startX, startY, map[startX][startY]));
        distance[startX][startY] = map[startX][startY];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (distance[now.x][now.y] < now.distance) continue;

            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dir[i][0];
                int mvy = now.y + dir[i][1];
                if (mvx < 0 || mvy < 0 || size <= mvx || size <= mvy) continue;

                int tempDistance = now.distance + map[mvx][mvy];
                if (tempDistance < distance[mvx][mvy]) {
                    pq.add(new Node(mvx, mvy, tempDistance));
                    distance[mvx][mvy] = tempDistance;
                }
            }
        }
        return distance[size - 1][size - 1];
    }
}
