package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2615_오목 {
    private static final boolean[][][] visited = new boolean[4][19][19];
    private static final char[][] map = new char[19][19];
    private static final int[] dirX = new int[]{1, 1, 0, -1};
    private static final int[] dirY = new int[]{0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        boolean flag1 = false, flag2 = false;
        int dirx1 = 0, diry1 = 0, dirx2 = 0, diry2 = 0;

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == '1' || map[i][j] == '2') {
                    if (sameColor(i, j)) {
                        if (map[i][j] == '1' && !flag1) {
                            flag1 = true;
                            dirx1 = i + 1;
                            diry1 = j + 1;
                        } else if (!flag2) {
                            flag2 = true;
                            dirx2 = i + 1;
                            diry2 = j + 1;
                        }
                    }
                }
            }
        }

        for (int i = 18; 0 <= i; i--) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == '1' || map[i][j] == '2') {
                    if (sameColor2(i, j)) {
                        if (map[i][j] == '1' && !flag1) {
                            flag1 = true;
                            dirx1 = i + 1;
                            diry1 = j + 1;
                        } else if (!flag2) {
                            flag2 = true;
                            dirx2 = i + 1;
                            diry2 = j + 1;
                        }
                    }
                }
            }
        }

        if (flag1 ^ flag2) {
            if (flag1) {
                sb.append(1).append("\n");
                sb.append(dirx1).append(" ").append(diry1);
            } else {
                sb.append(2).append("\n");
                sb.append(dirx2).append(" ").append(diry2);
            }
        } else {
            sb.append(0);
        }

        System.out.println(sb);

    }

    private static boolean sameColor(int x, int y) {
        for (int i = 0; i < 3; i++) {
            int depth = dfs(1, x, y, i);
            if (depth == 5) return true;
        }
        return false;
    }

    private static boolean sameColor2(int x, int y) {
        int depth = dfs(1, x, y, 3);
        return depth == 5;
    }

    private static int dfs(int depth, int x, int y, int dir) {
        int tmpX = x + dirX[dir];
        int tmpY = y + dirY[dir];

        if (tmpY < 0 || 19 <= tmpY || tmpX < 0 || 19 <= tmpX || map[tmpX][tmpY] != map[x][y] || visited[dir][tmpX][tmpY]) {
            return depth;
        }

        visited[dir][tmpX][tmpY] = true;
        return dfs(depth + 1, tmpX, tmpY, dir);
    }
}
