package 백준.BFSDFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562_나이트의이동 {
    private static final StringBuilder sb = new StringBuilder();
    private static final int[][] dir = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    private static int[][] visited;
    private static int[] start;
    private static int[] end;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int sz = Integer.parseInt(br.readLine());
            visited = new int[sz][sz];

            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs() {
        if (start[0] == end[0] && start[1] == end[1]) return 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if(now.x==end[0]&& now.y==end[1]) return visited[end[0]][end[1]] - 1;

            for (int i = 0; i < 8; i++) {
                int mvx = now.x + dir[i][0];
                int mvy = now.y + dir[i][1];

                if (mvx < 0 || visited.length <= mvx || mvy < 0 || visited.length <= mvy) continue;

                if(visited[mvx][mvy]==0){
                    visited[mvx][mvy]=visited[now.x][now.y]+1;
                    q.add(new Point(mvx,mvy));
                }
            }
        }

        return -1;
    }
}
