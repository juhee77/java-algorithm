package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj_2151_거울설치 {
    private static int row, col;
    private static char[][] map;
    private static final int INF = (int) 1e8;
    private static final int[] dirX = {0, -1, 0, 1}; //오 위 왼 아
    private static final int[] dirY = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int startX = 0, startY = 0;
        col = row = Integer.parseInt(br.readLine());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp[j];
                if (temp[j] == '#') {
                    startX = i;
                    startY = j;
                }
            }
        }
        System.out.println(findMinMirror(startX, startY));
    }

    /*다익스트라 이용*/
    private static int findMinMirror(int startX, int startY) {
        int[][][] mirror = new int[4][row][col];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < row; j++) {
                Arrays.fill(mirror[i][j], INF);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        map[startX][startY] = '.';
        for (int i = 0; i < 4; i++) {
            mirror[i][startX][startY] = 0;
            pq.add(new Node(startX, startY, 0, i));
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (mirror[now.dir][now.x][now.y] < now.mirror) continue;

            if (map[now.x][now.y] == '#') return now.mirror;
            //거울을 둘수 없는경우 원래 진행방향으로 간다.
            else if (map[now.x][now.y] == '.') checkingAndPut(mirror[now.dir], pq, now, now.dir);
            else {
                for (int i = 0; i < 4; i++) {
                    //세방향으로만 가능하다.
                    if (i == (now.dir + 2) % 4) continue;
                    checkingAndPut(mirror[i], pq, now, i);
                }
            }
        }
        return -1;
    }

    private static void checkingAndPut(int[][] dirMirror, PriorityQueue<Node> pq, Node now, int changingDir) {
        int mvx = now.x + dirX[changingDir];
        int mvy = now.y + dirY[changingDir];
        if (mvx < 0 || mvy < 0 || row <= mvx || col <= mvy) return;
        if (map[mvx][mvy] == '*') return;

        //<= 으로 한 이유는 같은 1인상태여도 방향은 여러가지 일수 있으므로
        int tempCost = (now.dir == changingDir) ? now.mirror : now.mirror + 1;
        if (tempCost < dirMirror[mvx][mvy]) {
            pq.add(new Node(mvx, mvy, tempCost, changingDir));
            dirMirror[mvx][mvy] = tempCost;
        }
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

/*
5
#....
.....
.....
....#
!!!!!

4
#...
...!
!..!
...#

4
#...
....
!..!
...#
*/