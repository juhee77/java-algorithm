package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_6087_레이저통신RE {
    private static int row, col;
    private static char[][] map;
    private static final int INF = (int) 1e8;
    private static final int[] dirX = {-1, 1, 0, 0}; //위 아래 오 왼
    private static final int[] dirY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = 0, startY = 0;
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp[j];
                if (temp[j] == 'C') {
                    startX = i;
                    startY = j;
                }
            }
        }
        System.out.println(findMinMirror(startX, startY));
    }

    /*다익스트라 이용*/
    private static int findMinMirror(int startX, int startY) {
        int[][] mirror = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(mirror[i], INF);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < 4; i++) {
            pq.add(new Node(startX, startY, 0, i));
        }
        mirror[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (mirror[now.x][now.y] < now.mirror) continue;

            if (map[now.x][now.y] == 'C' && !(now.x == startX && now.y == startY)) {
                return now.mirror;
            }

            for (int i = 0; i < 4; i++) {
                int mvx = now.x + dirX[i];
                int mvy = now.y + dirY[i];
                if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) continue;
                if (map[mvx][mvy] == '*') continue;

                //<= 으로 한 이유는 같은 1인상태여도 방향은 여러가지 일수 있으므로
                int tempCost = (now.dir == i) ? now.mirror : now.mirror + 1;
                if (tempCost <= mirror[mvx][mvy]) {
                    pq.add(new Node(mvx, mvy, tempCost, i));
                    mirror[mvx][mvy] = tempCost;
                }
            }
        }
        return -1;
    }

    private static class Node implements Comparable<Node> {
        int x, y, mirror, dir;

        public Node(int x, int y, int mirror, int dir) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.dir = dir;
        }

        @Override
        public int compareTo(Node o) {
            return mirror - o.mirror;
        }
    }
}
