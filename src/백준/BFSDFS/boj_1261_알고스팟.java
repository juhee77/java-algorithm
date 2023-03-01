package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1261_알고스팟 {
    private static int row, col;
    private static char[][] map;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static class Point implements Comparable<Point> {
        int x, y, nowBreakWall;

        public Point(int x, int y, int nowBreakWall) {
            this.x = x;
            this.y = y;
            this.nowBreakWall = nowBreakWall;
        }

        @Override
        public int compareTo(Point other) {
            return nowBreakWall - other.nowBreakWall;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        if (row == 1 && col == 1) return 0;

        //문제에서 (1,1),(n,m)은 항상 뚫려 있다고 했으므로 시작점과 마지막 점은 확인하지 않았다.
        boolean[][] visit = new boolean[row][col];
        visit[0][0] = true;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));

        //덱을 사용해서 +1하는 경우는 뒤에다, 아닌경우는 앞에다 넣는 방식으로 하면 정렬 시간을 줄일수 있다.(우선순위 큐를 사용하지 않아도된다.+ 클래스를 구현하지 않아도 된다)
        while (!pq.isEmpty()) {
            Point now = pq.poll();
            for (int[] dir : dirs) {
                int movedX = now.x + dir[0];
                int movedY = now.y + dir[1];
                if (movedX < 0 || movedY < 0 || row <= movedX || col <= movedY) continue;//범위를 벗어남
                if (visit[movedX][movedY]) continue; //이미 방문함
                if (movedX == (row - 1) && movedY == (col - 1)) return now.nowBreakWall;
                //하나 부셔야 한다
                if (map[movedX][movedY] == '1') pq.add(new Point(movedX, movedY, now.nowBreakWall + 1));
                else pq.add(new Point(movedX, movedY, now.nowBreakWall));
                visit[movedX][movedY] = true;
            }
        }
        return -1;//불가능한 경우
    }
}
