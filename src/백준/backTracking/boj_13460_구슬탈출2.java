package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13460_구슬탈출2 {
    static class index {
        private int redx, redy;
        private int bluex, bluey;
        private int time;

        public index(int redx, int redy, int bluex, int bluey, int time) {
            this.redx = redx;
            this.redy = redy;
            this.bluex = bluex;
            this.bluey = bluey;
            this.time = time;
        }

        public void redmove(int dirx, int diry) {
            while (true) {
                if (arr[redx + dirx][redy + diry] == 0) {
                    redx += dirx;
                    redy += diry;
                }else if (arr[redx + dirx][redy + diry] == 3) {
                    redx += dirx;
                    redy += diry;
                    return;
                } else return;
            }

        }

        public void bluemove(int dirx, int diry) {
            while (true) {
                if (arr[bluex + dirx][bluey+diry] == 0) {
                    bluex += dirx;
                    bluey += diry;
                }
                else if (arr[bluex + dirx][bluey+diry] == 3) {
                    bluex += dirx;
                    bluey += diry;
                    return;
                }else return;
            }

        }


        public index move(int dirx, int diry, int first) {
            arr[redx][redy] = 0;
            arr[bluex][bluey] = 0;
            int saver;
            int saveb;

            if (first == 1) { //빨간색 먼저
                redmove(dirx, diry);
                saver = arr[redx][redy];
                arr[redx][redy] = (saver==0)?2:saver;
                bluemove(dirx, diry);
                arr[redx][redy] = saver;

            } else {
                bluemove(dirx, diry);
                saveb = arr[bluex][bluey];
                arr[bluex][bluey] = (saveb==0)?1:saveb;
                redmove(dirx, diry);
                arr[bluex][bluey]=saveb;
            }

            return new index(redx, redy, bluex, bluey, time + 1);
        }

    }

    private static Queue<index> queue = new LinkedList<>();
    static int[][] arr;
    private static final int[] dirx = {-1, 1, 0, 0};//위아래 오른쪽 왼쪽
    private static final int[] diry = {0, 0, 1, -1};
    private static boolean[][][][] visit;

    private static int bfs() {
        while (!queue.isEmpty()) {
            index now = queue.poll();

            //위로가는경우
            //더 위에 있는걸 먼저 굴려야함(red가 1 blue 가 0 )
            int top = (now.redx < now.bluex) ? 1 : 0;
            //아래로 가는경우
            int bottom = (now.redx > now.bluex) ? 1 : 0;
            //오른쪽으로 가는 경우
            int right = (now.redy > now.bluey) ? 1 : 0;
            //왼쪽으로 가는경우
            int left = (now.redy < now.bluey) ? 1 : 0;
            int[] first = new int[]{top, bottom, right, left};

            if (now.time == 10) return -1;

            for (int i = 0; i < 4; i++) {
                index now2 = new index(now.redx,now.redy,now.bluex,now.bluey,now.time);
                arr[now2.redx][now2.redy] = 2;
                arr[now2.bluex][now2.bluey] = 1;
                index mv = now2.move(dirx[i], diry[i], first[i]);
                if (arr[mv.bluex][mv.bluey]==3) continue;
                else if (arr[mv.redx][mv.redy] == 3)return mv.time;
                else if (!visit[mv.redx][mv.redy][mv.bluex][mv.bluey]) {
                    queue.add(mv);
                    visit[mv.redx][mv.redy][mv.bluex][mv.bluey] = true;
                }

            }

            arr[now.redx][now.redy] = 0;
            arr[now.bluex][now.bluey] = 0;

        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        arr = new int[row][col];
        visit = new boolean[row][col][row][col]; //앞이 x 뒤가 y
        int[] b = new int[2], r = new int[2];
        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                char tmp = temp.charAt(j);
                int num = 0;
                if (tmp == '#') num = -1; //벽은 -1
                else if (tmp == 'B') {
                    b[0] = i;b[1] = j;
                } else if (tmp == 'R') {
                    r[0] = i;r[1] = j;
                } else if (tmp == 'O') num = 3;

                arr[i][j] = num;
            }
        }

        queue.add(new index(r[0], r[1], b[0], b[1], 0));
        visit[r[0]][r[1]][b[0]][b[1]] = true;

        System.out.println(bfs());
    }
}
/*
7 7
#######
#R....#
#.....#
#.....#
#....B#
#.....#
#######
 */