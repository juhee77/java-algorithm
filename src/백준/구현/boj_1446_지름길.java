package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1446_지름길 {
    private static int n, d, min = Integer.MAX_VALUE;

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            //greedy? or 완탐
            //1.greedy
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map, (Comparator.comparingInt(o -> o[0])));


        dfs(0, 0, 0);
        System.out.println(min);
    }

    private static void dfs(int nowDepth, int now, int cost) {
        if (now <= d) {
            min = Math.min(cost + (d - now), min);
        }

        for (int i = nowDepth; i < n; i++) {
            if (d < map[i][1]) continue;

            //지름길 가는경우
            if (now <= map[i][0]) {
                dfs(i + 1, map[i][1], cost + map[i][2] + (map[i][0] - now));
            }
            //지름길 가지 않는 경우
            dfs(i + 1, now, cost);

        }

    }
}
