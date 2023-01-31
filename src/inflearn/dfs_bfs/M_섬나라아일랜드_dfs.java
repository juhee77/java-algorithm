package inflearn.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M_섬나라아일랜드_dfs {
    private static int[][] map;
    private static int size;
    private static final int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    /**
     * visit 배열이 없어도 된다.
     * 대신에 섬을 바다로 만드는걸로 방문처리를 대신함
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution());
    }

    private static int solution() {
        int ans = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    ans++;
                }
            }
        }

        return ans;
    }

    private static void dfs(int x, int y) {
        if (x < 0 || y < 0 || size <= x || size <= y) return;
        if (map[x][y] == 1) {
            map[x][y] = 0;
            for (int[] ints : dir) {
                dfs(x + ints[0], y + ints[1]);
            }
        }
    }
}
