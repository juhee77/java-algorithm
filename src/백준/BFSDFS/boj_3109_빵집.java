package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_3109_빵집 {
    private static char[][] map;
    private static int row, col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        map = new char[row][col];
        for (int i = 0; i < row; i++) {
            map[i] = br.readLine().toCharArray();
        }

        //오른쪽 1, 오른쪽 위 대각선 2 , 오른쪽 아래 대각선 3
        int cnt = 0;
        for (int i = 0; i < row; i++) {
            if (map[i][0] == 'x') continue;
            if (dfs(0, i)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static boolean dfs(int y, int x) {
        if (y == col - 1) {
            return true;
        } else {
            //오른쪽 위
            map[x][y] = ':'; //어차피 이미 갔던 길이 안되는 경우는 그 길을 못가는 경우임!!
            if (0 <= x - 1 && map[x - 1][y + 1] == '.') {
                if (dfs(y + 1, x - 1)) {
                    return true;
                }
            }

            if (map[x][y + 1] == '.') {
                if (dfs(y + 1, x)) return true;
            }

            //오른쪽 아래
            if (x + 1 < row && map[x + 1][y + 1] == '.') {
                if (dfs(y + 1, x + 1)) return true;
            }
        }
        return false;
    }
}
