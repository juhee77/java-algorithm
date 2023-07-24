package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_9376_탈옥 {
    private static final int[] dirX = {-1, 1, 0, 0};
    private static final int[] dirY = {0, 0, -1, 1};
    private static int row, col;

    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());

            Point p1 = null, p2 = null;
            map = new char[row + 2][col + 2];
            Arrays.fill(map[0], '.');
            Arrays.fill(map[row + 1], '.');

            for (int i = 1; i < row + 1; i++) {
                char[] charArray = br.readLine().toCharArray();
                map[i][0] = '.';
                map[i][col + 1] = '.';
                for (int j = 1; j < col + 1; j++) {
                    map[i][j] = charArray[j - 1];
                    if (map[i][j] == '$') {
                        map[i][j] = '.';
                        //도둑
                        if (p1 == null) {
                            p1 = new Point(i, j, 0);
                        } else {
                            p2 = new Point(i, j, 0);
                        }
                    }
                }
            }

            int[][] dist1 = findEach(new int[row + 2][col + 2], p1);
            int[][] dist2 = findEach(new int[row + 2][col + 2], p2);
            int[][] distOut = findEach(new int[row + 2][col + 2], new Point(0, 0, 0));

//            printArr(dist1);
//            printArr(dist2);
//            printArr(distOut);

            //a,b각각 빠져나오는게 이득인 경우
            int minEach = findMin(dist1) + findMin(dist2);
            int minJoin = getMinimumSum(dist1, dist2, distOut);
            sb.append(Math.min(minJoin, minEach)).append("\n");
//            sb.append(minJoin).append(" ");
        }

        System.out.println(sb);
    }

    private static int findMin(int[][] dist) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= col; i++) {
            if (map[1][i] != '*') min = Math.min(dist[1][i], min);
            if (map[row][i] != '*') min = Math.min(dist[row][i], min);
        }
        for (int i = 2; i <= row; i++) {
            if (map[i][1] != '*') min = Math.min(dist[i][1], min);
            if (map[i][col] != '*') min = Math.min(dist[i][col], min);
        }
        return min;
    }


    private static int getMinimumSum(int[][] dist1, int[][] dist2, int[][] distOut) {
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < dist1.length; i++) {
            for (int j = 0; j < dist1[i].length; j++) {
                if (map[i][j] == '*')
                    continue;

                if (dist1[i][j] > 0 && dist2[i][j] > 0 && distOut[i][j] > 0) {//모두 이 문을 열었을 경우만
                    int sum = dist1[i][j] + dist2[i][j] + distOut[i][j];
                    if (map[i][j] == '#') {
                        sum -= 2;
                    }
                    if (0 <= sum)
                        minSum = Math.min(minSum, sum);
                }

            }
        }

        return minSum;
    }

    private static int[][] findEach(int[][] dist, Point p) {
        //point를 기준으로 시작
        boolean[][] visited = new boolean[row + 2][col + 2];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(p);
        visited[p.x][p.y] = true;
        dist[p.x][p.y] = p.door;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int j = 0; j < 4; j++) {
                int mvX = point.x + dirX[j];
                int mvY = point.y + dirY[j];

                if (mvX < 0 || row + 2 <= mvX || mvY < 0 || col + 2 <= mvY) continue;
                if (visited[mvX][mvY]) continue;
                if (map[mvX][mvY] == '#' || map[mvX][mvY] == '.') {
                    dist[mvX][mvY] = (map[mvX][mvY] == '#') ? point.door + 1 : point.door;
                    queue.add(new Point(mvX, mvY, dist[mvX][mvY]));
                    visited[mvX][mvY] = true;
                }
            }
        }
        return dist;
    }

    private static class Point implements Comparable<Point> {
        int x, y;
        int door;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.door = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.door - o.door;
        }
    }

}
/*
1
10 10
##########
##########
##########
##########
##########
##########
##$#######
##########
########$#
##########
1
3 5
*****
#$*$#
*****

 */
