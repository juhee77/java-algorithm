package 백준.graph.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Boj_1058_친구 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = chars[j] != 'N';
            }
        }

        boolean[][] dist = new boolean[n][n];
        for (int p = 0; p < n; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (map[i][p] && map[p][j]) {
                        dist[i][j] = true;
                    }

                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (dist[i][j] || map[i][j]) temp++;
            }
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);


    }
}
