package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_20057_마법사상어와토네이도 {

    public static final int PLACE = -1;
    public static final int ORIGINAL = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] dirs = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int[][][] percent = new int[4][][];
        percent[0] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 10, 7, 1, 0, 0, 0},
                {5, -1, PLACE, ORIGINAL, 0, 0, 0},
                {0, 10, 7, 1, 0, 0, 0},
                {0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        percent[1] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, ORIGINAL, 1, 0, 0},
                {0, 2, 7, PLACE, 7, 2, 0},
                {0, 0, 10, -1, 10, 0, 0},
                {0, 0, 0, 5, 0, 0, 0},
        };
        percent[2] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 1, 7, 10, 0},
                {0, 0, 0, ORIGINAL, PLACE, -1, 5},
                {0, 0, 0, 1, 7, 10, 0},
                {0, 0, 0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
        };
        percent[3] = new int[][]{
                {0, 0, 0, 5, 0, 0, 0},
                {0, 0, 10, -1, 10, 0, 0},
                {0, 2, 7, PLACE, 7, 2, 0},
                {0, 0, 1, ORIGINAL, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
        };

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int nowX, nowY;
        int nowDir = 0;
        nowY = nowX = n / 2;
        //dirHold 2번에 한번씩 증가
        int hold = 1;
        //방향변경 횟수
        int dirHold = 0;

        int outSend = 0;
        int i = 0;
        while (true) {
            //하나의 디렉션에 대해서 몇번을 진행해야하는지
            //모래 이동
            int aX = nowX + dirs[nowDir][0];
            int aY = nowY + dirs[nowDir][1];
            //이미 범위를 벗어난 공간임, 측정 불가
            if (0 <= aX && aX < n && 0 <= aY && aY < n) {
                int a = map[aX][aY];
                map[aX][aY] = 0;
                int remain = a;
                for (int p = nowX - 3; p <= nowX + 3; p++) {
                    for (int q = nowY - 3; q <= nowY + 3; q++) {
                        if (percent[nowDir][p - nowX + 3][q - nowY + 3] == -1) continue;
                        int nowSend = a * percent[nowDir][p - nowX + 3][q - nowY + 3] / 100;
                        if (0 <= p && p < n && 0 <= q && q < n) {
                            map[p][q] += nowSend;
                        } else {
                            outSend += nowSend;
                        }
                        remain -= nowSend;
                    }
                }

                aX = aX + dirs[nowDir][0];
                aY = aY + dirs[nowDir][1];
                if (0 <= aX && aX < n && 0 <= aY && aY < n) {
                    map[aX][aY] += remain;
                } else {
                    outSend += remain;
                }
            }

            i++;
            if (nowY == 0 && nowX == 0) {
                break;
            }
            nowX += dirs[nowDir][0];
            nowY += dirs[nowDir][1];
            if (i == hold) {
                dirHold++;
                //방향을 바꾸는 순서
                if (dirHold == 2) {
                    hold++;
                    dirHold = 0;
                }
                nowDir = (nowDir + 1) % 4;
                i = 0;
            }
        }

        System.out.println(outSend);
    }
}
