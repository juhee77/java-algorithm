package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4179_불2 {
    private static char[][] map;
    private static int row, col;
    private static Queue<Point> fires = new LinkedList<>();
    private static Queue<Point> jihon = new LinkedList<>();

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = temp.charAt(j);
                if (map[i][j] == 'F') {
                    fires.add(new Point(i, j));
                } else if (map[i][j] == 'J') {
                    jihon.add(new Point(i, j));
                }
            }
        }

        int mvCnt = findExit();
        if (mvCnt == -1) {
            System.out.println("IMPOSSIBLE");
        } else System.out.println(mvCnt);
    }


    private static int findExit() {

        int mvCnt = 0;
        while (!jihon.isEmpty()) {
            //불 옮기기
            int fireCnt = fires.size();
            for (int i = 0; i < fireCnt; i++) {
                Point poll = fires.poll();
                for (int[] dir : dirs) {
                    int mvX = poll.x + dir[0];
                    int mvY = poll.y + dir[1];
                    if (0 <= mvX && 0 <= mvY && mvX < row && mvY < col && (map[mvX][mvY] == '.' || map[mvX][mvY] == 'J')) {
                        map[mvX][mvY] = 'F';
                        fires.add(new Point(mvX, mvY));
                    }
                }
            }

            //내가 갈수있는거 한칸 가기
            mvCnt++;
            int myCnt = jihon.size();

            for (int i = 0; i < myCnt; i++) {
                Point now = jihon.poll();
                if (now.x == 0 || now.y == 0 || now.x == row - 1 || now.y == col - 1) {
                    return mvCnt;
                }

                for (int[] dir : dirs) {
                    int mvX = now.x + dir[0];
                    int mvY = now.y + dir[1];

                    if (0 <= mvX && 0 <= mvY && mvX <row && mvY < col && map[mvX][mvY] == '.') {
                        map[mvX][mvY] = 'J'; //상근이가 이미 다녀갔다표시
                        jihon.add(new Point(mvX, mvY));
                    }
                }
            }
        }
        return -1;
    }
}
