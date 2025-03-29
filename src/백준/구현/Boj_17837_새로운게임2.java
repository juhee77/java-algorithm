package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_17837_새로운게임2 {
    private static int[][] map;
    private static int[][][] nodeMap;
    private final static List<Node> list = new ArrayList<>();
    private final static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private static class Node {
        int index;
        int x, y;
        int dir;
        int count;

        public Node(int index, int x, int y, int dir) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.dir = dir;
            count = 0;
        }

        public void setPosition(int mvX, int mvY, int i) {
            this.x = mvX;
            this.y = mvY;
            this.count = i;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            list.add(new Node(i + 1, r, c, dir));
        }

        int turn = 1;
        while (turn < 1000) {
            int findLast = 0;
            fillNodeMaps();
            for (Node node : list) {
                //이동
                int mvX = node.x + dirs[node.dir][0];
                int mvY = node.y + dirs[node.dir][1];

                if (cantMove(mvX, mvY, n) || map[mvX][mvY] == 2) {
                    //반대쪽으로 이동할 수 있는지 확인
                    int mvDir = (node.dir / 2) * 2 + ((node.dir % 2 + 1) % 2);
                    node.dir = mvDir;
                    mvX = node.x + dirs[mvDir][0];
                    mvY = node.y + dirs[mvDir][1];
                    if (cantMove(mvX, mvY, n) || map[mvX][mvY] == 2) {
                        continue;
                    }
                }

                int beforex = node.x;
                int beforey = node.y;
                int nowLastIndex = findLastIndex(k, node.x, node.y);
                int nowIndex = findIndex(k, node.x, node.y, node.index);

                if (map[mvX][mvY] == 0) {
                    findLast = findLastIndex(k, mvX, mvY);
                    for (int i = nowIndex; i < nowLastIndex; i++) {
                        findLast = copyAndGetLastIndex(beforex, beforey, mvX, mvY, findLast, i);
                    }
                } else if (map[mvX][mvY] == 1) {
                    findLast = findLastIndex(k, mvX, mvY);
                    for (int i = nowLastIndex - 1; nowIndex <= i; i--) {
                        findLast = copyAndGetLastIndex(beforex, beforey, mvX, mvY, findLast, i);
                    }
                }
                if (findLast >= 4) break;
            }
            if (findLast >= 4) break;
            turn++;
        }
        System.out.println(turn == 1000 ? -1 : turn);
    }

    private static Integer findIndex(int k, int x, int y, int index) {
        for (int i = 0; i < k; i++) {
            if (nodeMap[x][y][i] == index) {
                return i;
            }
        }
        return null;
    }

    private static int copyAndGetLastIndex(int beforeX, int beforeY, int mvX, int mvY, int findLast, int i) {
        int index = nodeMap[beforeX][beforeY][i];
        nodeMap[mvX][mvY][findLast] = index;
        nodeMap[beforeX][beforeY][i] = 0;
        list.get(index - 1).setPosition(mvX, mvY, findLast++);
        return findLast;
    }

    private static int findLastIndex(int k, int mvX, int mvY) {
        for (int i = 0; i < k; i++) {
            if (nodeMap[mvX][mvY][i] == 0) {
                return i;
            }
        }
        return k;
    }

    private static boolean cantMove(int mvX, int mvY, int n) {
        return mvX < 0 || mvY < 0 || n <= mvX || n <= mvY;
    }

    private static void fillNodeMaps() {
        nodeMap = new int[map.length][map.length][list.size()];
        for (Node node : list) {
            nodeMap[node.x][node.y][node.count] = node.index;
        }
    }
}
