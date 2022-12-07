package 백준.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] map = new boolean[101][101];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int xS = Integer.parseInt(st.nextToken());
            int yS = Integer.parseInt(st.nextToken());
            int xE = Integer.parseInt(st.nextToken());
            int yE = Integer.parseInt(st.nextToken());

            colored(map, xS, xE, yS, yE);
        }

        System.out.println(totalColored(map));
    }

    private static int totalColored(boolean[][] map) {
        int cnt = 0;
        for (boolean[] booleans : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (booleans[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void colored(boolean[][] map, int xS, int xE, int yS, int yE) {
        for (int i = xS; i < xE; i++) {
            for (int j = yS; j < yE; j++) {
                map[i][j] = true;
            }
        }
    }
}
