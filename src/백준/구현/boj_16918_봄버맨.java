package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16918_봄버맨 {
    private static boolean[][] map;
    private static int R, C, N;
    private static final int[] dirx = new int[]{-1, 1, 0, 0};
    private static final int[] diry = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];

        /*init*/
        for (int i = 0; i < R; i++) {
            char[] rowInput = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = rowInput[j] != '.';
            }
        }

        List<Boom> boom = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            //폭탄 설치
            if (i % 2 == 0) {
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (map[r][c]) boom.add(new Boom(r, c));
                        else map[r][c] = true;
                    }
                }
            } else {
                for (Boom now : boom) {
                    //폭탄이 터진다
                    explosion(now);
                }
                boom.clear();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j]) sb.append("O");
                else sb.append(".");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void explosion(Boom tempBoom) {
        int x = tempBoom.x;
        int y = tempBoom.y;
        map[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int mvx = x + dirx[i];
            int mvy = y + diry[i];
            if (mvx < 0 || mvy < 0 || R <= mvx || C <= mvy) continue;
            map[mvx][mvy] = false;
        }
    }

    private static class Boom {
        int x, y;

        public Boom(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
