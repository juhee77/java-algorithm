package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_5427_불 {
    private static int w, h;
    private static char[][] map;
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private static Queue<Point> me = new LinkedList<>();
    private static Queue<Point> fires = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            me.clear();
            fires.clear();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '*') {
                        fires.add(new Point(i, j));
                    } else if (map[i][j] == '@') {
                        me.add(new Point(i, j));
                    }
                }
            }

            int mvCnt = findExit();
            if (mvCnt == -1) {
                sb.append("IMPOSSIBLE");
            } else sb.append(mvCnt);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int findExit() {

        int mvCnt = 0;
        while (!me.isEmpty()) {
            //내가 갈수있는거 한칸 가기
            mvCnt++;
            int myCnt = me.size();

            for (int i = 0; i < myCnt; i++) {
                Point now = me.poll();
                if (map[now.x][now.y] == '*') continue;//내가 있는곳에 불이있으면 그곳으로는 과거에 가면 안됐기 때문

                if (now.x == 0 || now.y == 0 || now.x == h - 1 || now.y == w - 1) {
                    return mvCnt;
                }

                for (int[] dir : dirs) {
                    int mvX = now.x + dir[0];
                    int mvY = now.y + dir[1];

                    if (0 <= mvX && 0 <= mvY && mvX < h && mvY < w && map[mvX][mvY] == '.') {
                        map[mvX][mvY] = '@'; //상근이가 이미 다녀갔다표시
                        me.add(new Point(mvX, mvY));
                    }
                }
            }


            //불 옮기기
            int fireCnt = fires.size();
            for (int i = 0; i < fireCnt; i++) {
                Point poll = fires.poll();
                for (int[] dir : dirs) {
                    int mvX = poll.x + dir[0];
                    int mvY = poll.y + dir[1];
                    if (0 <= mvX && 0 <= mvY && mvX < h && mvY < w && (map[mvX][mvY] == '.' || map[mvX][mvY] == '@')) {
                        map[mvX][mvY] = '*';
                        fires.add(new Point(mvX, mvY));
                    }
                }
            }
        }
        return -1;
    }


}
