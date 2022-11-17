package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1890_점프 {
    private static int[][] map;
    private static long[][] cs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());
        map = new int[line][line];
        cs = new long[line][line];
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < line; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cs[0][0] = 1;
        for (int x = 0; x < line; x++) {
            for (int y = 0; y < line; y++) {
                if (map[x][y] == 0)
                    continue;
                // X축 이동
                int mvx = x + map[x][y];
                if (mvx < map.length) {
                    cs[mvx][y] += cs[x][y];
                }
                // y축 이동
                int mvy = y + map[x][y];
                if (mvy < map.length) {
                    cs[x][mvy] += cs[x][y];
                }
            }
        }
        System.out.println(cs[line - 1][line - 1]);
    }
}