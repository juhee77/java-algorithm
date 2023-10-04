package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15685_드래곤커브 {
    private static final int[][] directions = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static final boolean[][] map = new boolean[102][102];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int repeat = Integer.parseInt(st.nextToken());

            draw(startX, startY, direction, repeat);
        }


        int cnt = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void draw(int startX, int startY, int direction, int repeat) {
        List<Integer> arr = new ArrayList<>();
        //baseLine
        int nowX = startX;
        int nowY = startY;
        int movedX = startX + directions[direction][0];
        int movedY = startY + directions[direction][1];
        map[nowX][nowY] = true;
        map[movedX][movedY] = true;
        arr.add((direction + 1) % 4);


        for (int i = 1; i <= repeat; i++) {
            for (int j = arr.size() - 1; 0 <= j; j--) {
                Integer nowDir = arr.get(j);
                nowX = movedX;
                nowY = movedY;
                movedX = nowX + directions[nowDir][0];
                movedY = nowY + directions[nowDir][1];

                map[movedX][movedY] = true;
                arr.add((nowDir + 1) % 4);
            }
        }
    }
}
