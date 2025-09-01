package 백준.BFSDFS.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11967_불켜기 {
    private static final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        int[][] lightOn = new int[size][size];
        int[][] switchOn = new int[size][size];
        ArrayList<Point>[][] switches = new ArrayList[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switches[i][j] = new ArrayList<>();
            }
        }

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int a1 = Integer.parseInt(st.nextToken()) - 1;
            int b1 = Integer.parseInt(st.nextToken()) - 1;
            switches[x1][y1].add(new Point(a1, b1));
        }

        Queue<Point> points = new ArrayDeque<>();
        points.add(new Point(0, 0));
        lightOn[0][0] = 1;
        while (!points.isEmpty()) {
            Point now = points.poll();

            //스위치가 있는 경우 모두 킨다.
            for (Point aSwitch : switches[now.x][now.y]) {
                if (lightOn[aSwitch.x][aSwitch.y] == 0) {
                    lightOn[aSwitch.x][aSwitch.y] = 1;
                } else if (lightOn[aSwitch.x][aSwitch.y] == -1) {
                    //이전에 못갔는데 갈 수 있게 되었으므로 다시 갈 수 있다고 체크한다.
                    lightOn[aSwitch.x][aSwitch.y] = 1;
                    points.add(new Point(aSwitch.x, aSwitch.y));
                }
            }
            switchOn[now.x][now.y] = 1;

            //방을 이동할 수 있는 경우 이동한다.
            for (int[] dir : dirs) {
                int mvX = now.x + dir[0];
                int mvY = now.y + dir[1];

                if (0 <= mvX && 0 <= mvY && mvX < size && mvY < size) {
                    //불이 겨져 있는 경우
                    if (lightOn[mvX][mvY] == 1) {
                        //불이 켜져 있는데 방문 되지 않은 경우(켤수 있는 스위치가 있는 경우)
                        if (switchOn[mvX][mvY] != 1) {
                            points.add(new Point(mvX, mvY));
                        }
                    } else {
                        lightOn[mvX][mvY] = -1;
                    }

                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (lightOn[i][j] == 1) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
