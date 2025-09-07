package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20057_마법사상어와토네이도2 {

    static int n;
    static int[][] map;
    static int outSand = 0;

    // 왼쪽 기준 방향
    static final int[][] baseSpread = {
            {-1, 1, 1}, {1, 1, 1},   // 1%
            {-1, 0, 7}, {1, 0, 7},   // 7%
            {-2, 0, 2}, {2, 0, 2},   // 2%
            {-1, -1, 10}, {1, -1, 10}, // 10%
            {0, -2, 5}               // 5%
    };

    // 좌, 하, 우, 상
    static final int[][] dirs = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = n / 2, y = n / 2; // 시작 위치 (중앙)
        int step = 1; // 한 방향으로 이동할 칸 수
        int dir = 0;  // 방향 인덱스
        int moveCount = 0;

        while (!(x == 0 && y == 0)) {
            for (int s = 0; s < step; s++) {
                x += dirs[dir][0];
                y += dirs[dir][1];
                spreadSand(x, y, dir);
                if (x == 0 && y == 0) break;
            }
            dir = (dir + 1) % 4;
            moveCount++;
            if (moveCount == 2) {
                moveCount = 0;
                step++;
            }
        }

        System.out.println(outSand);
    }

    // 모래 흩뿌리기
    static void spreadSand(int x, int y, int dir) {
        int sand = map[x][y];
        map[x][y] = 0;
        int spreadSum = 0;

        for (int[] sp : baseSpread) {
            int[] rot = rotate(sp[0], sp[1], dir);
            int nx = x + rot[0];
            int ny = y + rot[1];
            int amount = sand * sp[2] / 100;

            if (isIn(nx, ny)) map[nx][ny] += amount;
            else outSand += amount;

            spreadSum += amount;
        }

        // alpha 위치 (남은 모래)
        int nx = x + dirs[dir][0];
        int ny = y + dirs[dir][1];
        int remain = sand - spreadSum;

        if (isIn(nx, ny)) map[nx][ny] += remain;
        else outSand += remain;
    }

    // 좌표 회전 (왼쪽 기준 → dir 방향으로)
    static int[] rotate(int x, int y, int dir) {
        for (int i = 0; i < dir; i++) {
            int temp = x;
            x = y;
            y = -temp;
        }
        return new int[]{x, y};
    }

    static boolean isIn(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
