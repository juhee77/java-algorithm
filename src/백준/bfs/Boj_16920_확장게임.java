package 백준.bfs;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16920_확장게임 {

    private static int n, m, s;
    private static int[] dis, castles;
    private static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private static char[][] map;
    private static Queue<Point>[] q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        castles = new int[s + 1];
        q = new LinkedList[s + 1];
        dis = new int[s + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= s; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
            q[i] = new LinkedList<>();
        }

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if ('1' <= map[i][j] && map[i][j] <= '9') {
                    int userNo = map[i][j] - '0';
                    q[userNo].add(new Point(j, i));
                    castles[userNo]++;
                }
            }
        }

        while (true) {
            boolean isExpanded = false;
            for (int u = 1; u <= s; u++) {
                int moveLimit = dis[u];
                for (int i1 = 0; i1 < moveLimit; i1++) {
                    int size = q[u].size();
                    for (int j = 0; j < size; j++) {
                        Point now = q[u].poll();
                        for (int[] dir : dirs) {
                            int mvX = now.x + dir[0];
                            int mvY = now.y + dir[1];
                            if (mvX < 0 || mvY < 0 || mvX >= m || mvY >= n) continue;
                            if (map[mvY][mvX] == '.') {
                                map[mvY][mvX] = (char) (u + '0');
                                q[u].add(new Point(mvX, mvY));
                                castles[u]++;
                                isExpanded = true;
                            }
                        }
                    }
                    if (q[u].isEmpty()) break;
                }
            }
            if (!isExpanded) break;
        }

        for (int i = 1; i <= s; i++) {
            System.out.print(castles[i] + " ");
        }
        System.out.println();
    }

}
