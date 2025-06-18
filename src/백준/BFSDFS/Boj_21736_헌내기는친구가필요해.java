package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_21736_헌내기는친구가필요해 {
    private static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int answer =0;
        int nowR = -1, nowC = -1;
        for (int i = 0; i < r; i++) {
            String in = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = in.charAt(j);
                if(map[i][j] == 'I'){
                    nowR = i;
                    nowC = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        queue.offer(new int[]{nowR, nowC});
        visited[nowR][nowC] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || map[nx][ny]=='X') continue;
                if (map[nx][ny] == 'P') {
                    answer++;
                }

                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }

        System.out.println(answer==0?"TT":answer);
    }
}
