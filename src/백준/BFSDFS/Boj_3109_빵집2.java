package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3109_빵집2 {
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1}; // 오른쪽 위, 오른쪽, 오른쪽 아래
    private static int row, col;
    private static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        map = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        cnt = 0;
        for (int i = 0; i < row; i++) {
            if (dfs(i, 0)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean dfs(int x, int y) {
        visited[x][y] = true;

        if (y == col - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + 1;

            if (isValidPosition(nx, ny) && !visited[nx][ny] && map[nx][ny] == '.') {
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
