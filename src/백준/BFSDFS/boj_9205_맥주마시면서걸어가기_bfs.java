package 백준.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9205_맥주마시면서걸어가기_bfs {
    private static int[][] points;
    private static boolean[] visited;
    private static boolean happy;
    private static int endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            happy = false;

            int market = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            points = new int[market][2];
            visited = new boolean[market];

            for (int i = 0; i < market; i++) {
                st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            dfs(startX, startY);

            if (happy) sb.append("happy").append("\n");
            else sb.append("sad").append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int beforeX, int beforeY) {
        if (happy) return;

        //마지막 점에 갈 수 있는지
        int distance = Math.abs(beforeX - endX) + Math.abs(beforeY - endY);
        if (distance <= 1000) {
            happy = true;
            return;
        }

        for (int i = 0; i < points.length; i++) {
            if (visited[i]) continue;

            distance = Math.abs(beforeX - points[i][0]) + Math.abs(beforeY - points[i][1]);
            if (1000 < distance) continue;

            visited[i] = true;
            dfs(points[i][0], points[i][1]);

        }
    }
}
